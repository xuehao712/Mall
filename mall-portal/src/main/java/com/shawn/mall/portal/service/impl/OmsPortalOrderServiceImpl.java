package com.shawn.mall.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.exception.Asserts;
import com.shawn.mall.common.service.RedisService;
import com.shawn.mall.mapper.*;
import com.shawn.mall.model.*;
import com.shawn.mall.portal.component.CancelOrderSender;
import com.shawn.mall.portal.dao.PortalOrderDao;
import com.shawn.mall.portal.dao.PortalOrderItemDao;
import com.shawn.mall.portal.dao.SmsCouponHistoryDao;
import com.shawn.mall.portal.domain.*;
import com.shawn.mall.portal.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Front end order service impl
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;
    @Autowired
    private UmsMemberCouponService memberCouponService;
    @Autowired
    private UmsIntegrationConsumeSettingMapper integrationConsumeSettingMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private PortalOrderItemDao orderItemDao;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Autowired
    private PortalOrderDao portalOrderDao;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public ConfirmOrderResult generateConfirmOrder(List<Long> cartIds) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        UmsMember currentMember = memberService.getCurrentMember();
        //Get cart info
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),cartIds);
        result.setCartPromotionItemList(cartPromotionItemList);
        //Get member receive address list
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.list();
        result.setMemberReceiveAddressList(memberReceiveAddressList);
        //Get member available coupon list
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList,1);
        result.setCouponHistoryDetailList(couponHistoryDetailList);
        //Get user integration
        result.setMemberIntegration(currentMember.getIntegration());
        //Get integration use rule
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        result.setIntegrationConsumeSetting(integrationConsumeSetting);
        //Cal total
        ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartPromotionItemList);
        result.setCalcAmount(calcAmount);
        return result;
    }

    @Override
    public Map<String,Object> generateOrder(OrderParam orderParam) {
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        //Get cart info and promotion info
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),orderParam.getCartIds());
        for(CartPromotionItem cartPromotionItem:cartPromotionItemList) {
            //Generate product info
            OmsOrderItem orderItem = new OmsOrderItem();
            orderItem.setProductId(cartPromotionItem.getProductId());
            orderItem.setProductName(cartPromotionItem.getProductName());
            orderItem.setProductPic(cartPromotionItem.getProductPic());
            orderItem.setProductAttr(cartPromotionItem.getProductAttr());
            orderItem.setProductBrand(cartPromotionItem.getProductBrand());
            orderItem.setProductSn(cartPromotionItem.getProductSn());
            orderItem.setProductPrice(cartPromotionItem.getPrice());
            orderItem.setProductQuantity(cartPromotionItem.getQuantity());
            orderItem.setProductSkuId(cartPromotionItem.getProductSkuId());
            orderItem.setProductSkuCode(cartPromotionItem.getProductSkuCode());
            orderItem.setProductCategoryId(cartPromotionItem.getProductCategoryId());
            orderItem.setPromotionAmount(cartPromotionItem.getReduceAmount());
            orderItem.setPromotionName(cartPromotionItem.getPromotionMessage());
            orderItem.setGiftIntegration(cartPromotionItem.getIntegration());
            orderItem.setGiftGrowth(cartPromotionItem.getGrowth());
            orderItemList.add(orderItem);
        }
        //Check if product has stock
        if(!hasStock(cartPromotionItemList)){
            Asserts.fail("Product is out of stock");
        }

        //Check is used coupon
        if(orderParam.getCouponId() == null){
            for(OmsOrderItem orderItem:orderItemList){
                orderItem.setCouponAmount(new BigDecimal(0));
            }
        } else {
            SmsCouponHistoryDetail couponHistoryDetail = getUseCoupon(cartPromotionItemList,orderParam.getCouponId());
            if (couponHistoryDetail == null) {
                Asserts.fail("Coupon is unavailable");
            }
            handleCouponAmount(orderItemList,couponHistoryDetail);
        }
        //Check if used integration
        if(orderParam.getUseIntegration()==null || orderParam.getUseIntegration().equals(0)){
            for(OmsOrderItem orderItem:orderItemList) {
                orderItem.setIntegrationAmount(new BigDecimal(0));
            }
        }else{
            BigDecimal totalAmount = calcTotalAmount(orderItemList);
            BigDecimal integrationAmount = getUseIntegrationAmount(orderParam.getUseIntegration(),totalAmount,currentMember,orderParam.getCouponId()!=null);
            if (integrationAmount.compareTo(new BigDecimal(0)) == 0) {
                Asserts.fail("Integration is not available");
            } else {
                for(OmsOrderItem orderItem:orderItemList) {
                    BigDecimal perAmount = orderItem.getProductPrice().divide(totalAmount,3, RoundingMode.HALF_EVEN).multiply(integrationAmount);
                    orderItem.setIntegrationAmount(perAmount);
                }
            }
        }
        //Cal order_item real price
        handleRealAmount(orderItemList);
        //Stock lock
        lockStock(cartPromotionItemList);
        //Cal final price
        OmsOrder order = new OmsOrder();
        order.setDiscountAmount(new BigDecimal(0));
        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionAmount(calcPromotionAmount(orderItemList));
        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        if (orderParam.getCouponId() == null) {
            order.setCouponAmount(new BigDecimal(0));
        } else{
            order.setCouponId(orderParam.getCouponId());
            order.setCouponAmount(calcCouponAmount(orderItemList));
        }
        if (orderParam.getUseIntegration() == null) {
            order.setIntegration(0);
            order.setIntegrationAmount(new BigDecimal(0));
        } else {
            order.setIntegration(orderParam.getUseIntegration());
            order.setIntegrationAmount(calcIntegrationAmount(orderItemList));
        }
        order.setPayAmount(calcPayAmount(order));
        //Convert to order info and insert to database
        order.setMemberId(currentMember.getId());
        order.setCreateTime(new Date());
        order.setMemberUsername(currentMember.getUsername());
        //Payment method 0->unpaid 1->card 2->paypal
        order.setPayType(orderParam.getPayType());
        //Order source 0->PC 1->App
        order.setSourceType(1);
        //Order status 0->unpaid 1->unshipped 2->shipped 3->completed 4->closed 5->invalid order
        order.setStatus(0);
        //Order type 0->normal order 1->flash promotion order
        order.setOrderType(0);
        //Receiver info
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(orderParam.getMemberReceiveAddressId());
        order.setReceiverName(address.getName());
        order.setReceiverPhone(address.getPhoneNumber());
        order.setReceiverZipCode(address.getZipCode());
        order.setReceiverState(address.getState());
        order.setReceiverCity(address.getCity());
        order.setReceiverDetailAddress(address.getDetailAddress());
        //0->confirmed 1->unconfirmed
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        //Calculate earned integration
        order.setIntegration(calcGiftIntegration(orderItemList));
        //Calculate earned growth
        order.setGrowth(calcGiftGrowth(orderItemList));
        //Generate order number
        order.setOrderSn(generateOrderSn(order));
        //Set auto receive day
        List<OmsOrderSetting> orderSettings = orderSettingMapper.selectByExample(new OmsOrderSettingExample());
        if(CollUtil.isNotEmpty(orderSettings)){
            order.setAutoConfirmDay(orderSettings.get(0).getConfirmOvertime());
        }
        //Insert into order table and order_item table
        orderMapper.insert(order);
        for(OmsOrderItem orderItem:orderItemList) {
            orderItem.setOrderId(order.getId());
            orderItem.setOrderSn(order.getOrderSn());
        }
        orderItemDao.insertList(orderItemList);
        //If used coupon, update coupon status
        if(orderParam.getCouponId()!=null) {
            updateCouponStatus(orderParam.getCouponId(),currentMember.getId(),1);
        }
        //Update integration
        if(orderParam.getUseIntegration()!=null) {
            order.setUseIntegration(orderParam.getUseIntegration());
            memberService.updateIntegration(currentMember.getId(),currentMember.getIntegration()-orderParam.getUseIntegration());
        }
        //Delete cart order product
        deleteCartItemList(cartPromotionItemList,currentMember);
        //Send delay message cancel order
        sendDelayMessageCancelOrder(order.getId());
        Map<String,Object> result = new HashMap<>();
        result.put("order",order);
        result.put("orderItemList",orderItemList);
        return result;
    }

    @Override
    public Integer paySuccess(Long orderId,Integer payType){
        //Modify order pay status
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(1);
        order.setPaymentTime(new Date());
        order.setPayType(payType);
        orderMapper.updateByPrimaryKeySelective(order);
        //Restore ordered product locked stock, reduce real stock
        OmsOrderDetail orderDetail = portalOrderDao.getDetail(orderId);
        int count = portalOrderDao.updateSkuStock(orderDetail.getOrderItemList());
        return count;
    }

    @Override
    public Integer cancelTimeOutOrder() {
        Integer count = 0;
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        //Search Timeout, unpaid order
        List<OmsOrderDetail> timeOutOrders = portalOrderDao.getTimeOutOrder(orderSetting.getNormalOrderOvertime());
        if(CollectionUtils.isEmpty(timeOutOrders)){
            return count;
        }
        //Modify order status to be cancel
        List<Long> ids = new ArrayList<>();
        for(OmsOrderDetail timeOutOrder : timeOutOrders) {
            ids.add(timeOutOrder.getId());
        }
        portalOrderDao.updateOrderStatus(ids,4);
        for(OmsOrderDetail timeOutOrder:timeOutOrders) {
            //Unlock order stock lock
            portalOrderDao.releaseSkuStockLock(timeOutOrder.getOrderItemList());
            //Modify coupon usage
            updateCouponStatus(timeOutOrder.getCouponId(),timeOutOrder.getMemberId(),0);
            //Return integration
            if(timeOutOrder.getUseIntegration() !=null) {
                UmsMember member = memberService.getById(timeOutOrder.getMemberId());
                memberService.updateIntegration(timeOutOrder.getMemberId(),member.getIntegration() + timeOutOrder.getUseIntegration());
            }
        }
        return timeOutOrders.size();
    }

    @Override
    public void cancelOrder(Long orderId) {
        //Check unpaid order
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andStatusEqualTo(0).andDeleteStatusEqualTo(0);
        List<OmsOrder> cancelOrderList = orderMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(cancelOrderList)) {
            return;
        }
        OmsOrder cancelOrder = cancelOrderList.get(0);
        if (cancelOrder != null) {
            //Modify order to cancel
            cancelOrder.setStatus(4);
            orderMapper.updateByPrimaryKeySelective(cancelOrder);
            OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);
            //Unlock order
            if(!CollectionUtils.isEmpty(orderItemList)) {
                portalOrderDao.releaseSkuStockLock(orderItemList);
            }
            //modify coupon usage
            updateCouponStatus(cancelOrder.getCouponId(),cancelOrder.getMemberId(),0);
            //return unused integration
            if (cancelOrder.getUseIntegration() != null) {
                UmsMember member = memberService.getById(cancelOrder.getMemberId());
                memberService.updateIntegration(cancelOrder.getMemberId(),member.getIntegration()+cancelOrder.getUseIntegration());
            }
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        //Get order timeout time
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTime = orderSetting.getNormalOrderOvertime() * 60 *1000;
        //Send delay message
        cancelOrderSender.sendMessage(orderId,delayTime);
    }

    @Override
    public void confirmReceiveOrder(Long orderId) {
        UmsMember member = memberService.getCurrentMember();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(!member.getId().equals(order.getMemberId())){
            Asserts.fail("Cannot confirm others order");
        }
        if (order.getStatus() != 2) {
            Asserts.fail("This order is not yet shipped");
        }
        order.setStatus(3);
        order.setConfirmStatus(1);
        order.setReceiveTime(new Date());
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public CommonPage<OmsOrderDetail> list(Integer status,Integer pageNum,Integer pageSize) {
        if (status == -1) {
            status = null;
        }
        UmsMember member = memberService.getCurrentMember();
        PageHelper.startPage(pageNum,pageSize);
        OmsOrderExample orderExample = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0)
                .andMemberIdEqualTo(member.getId());
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        orderExample.setOrderByClause("create_time desc");
        List<OmsOrder> orderList = orderMapper.selectByExample(orderExample);
        CommonPage<OmsOrder> orderPage = CommonPage.restPage(orderList);
        //Set paging info
        CommonPage<OmsOrderDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if(CollUtil.isNotEmpty(orderList)) {
            return resultPage;
        }
        //Set data info
        List<Long> orderIds = orderList.stream().map(OmsOrder::getId).collect(Collectors.toList());
        OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
        orderItemExample.createCriteria().andOrderIdIn(orderIds);
        List<OmsOrderItem> orderItemList =orderItemMapper.selectByExample(orderItemExample);
        List<OmsOrderDetail> orderDetailList = new ArrayList<>();
        for(OmsOrder omsOrder:orderList) {
            OmsOrderDetail orderDetail = new OmsOrderDetail();
            BeanUtil.copyProperties(omsOrder,orderDetail);
            List<OmsOrderItem> relatedItemList = orderItemList.stream().filter(item -> item.getOrderId().equals(orderDetail.getId())).collect(Collectors.toList());
            orderDetail.setOrderItemList(relatedItemList);
            orderDetailList.add(orderDetail);
        }
        resultPage.setList(orderDetailList);
        return resultPage;
    }

    @Override
    public OmsOrderDetail detail(Long orderId) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(orderId);
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(example);
        OmsOrderDetail orderDetail = new OmsOrderDetail();
        BeanUtil.copyProperties(omsOrder,orderDetail);
        orderDetail.setOrderItemList(orderItemList);
        return orderDetail;
    }

    @Override
    public void deleteOrder(Long orderId) {
        UmsMember member = memberService.getCurrentMember();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(!member.getId().equals(order.getMemberId())){
            Asserts.fail("Cannot delete others order");
        }
        if(order.getStatus() == 3||order.getStatus()==4){
            order.setDeleteStatus(1);
            orderMapper.updateByPrimaryKey(order);
        }else{
            Asserts.fail("Only able to delete closed to completed order!");
        }
    }

    /**
     * Generate 18 digit order number, 8 digit date + 2 digit platform + 2 payment method + 6 auto increment id
     */
    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE + ":"+REDIS_KEY_ORDER_ID +date;
        Long increment = redisService.incr(key,1);
        sb.append(date);
        sb.append(String.format("%02d",order.getSourceType()));
        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    /**
     * Delete order product cart info
     */
    private void deleteCartItemList(List<CartPromotionItem> cartPromotionItemList,UmsMember currentMember) {
        List<Long> ids = new ArrayList<>();
        for(CartPromotionItem cartPromotionItem:cartPromotionItemList){
            ids.add(cartPromotionItem.getId());
        }
        cartItemService.delete(currentMember.getId(),ids);
    }

    /**
     * Calculate order gift growth
     */
    private Integer calcGiftGrowth(List<OmsOrderItem> orderItemList) {
        Integer sum = 0;
        for(OmsOrderItem orderItem:orderItemList) {
            sum+= orderItem.getGiftGrowth() * orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * Calculate order gift integration
     */
    private Integer calcGiftIntegration(List<OmsOrderItem> orderItemList) {
        int sum = 0;
        for(OmsOrderItem orderItem:orderItemList) {
            sum +=orderItem.getGiftIntegration() * orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * Update coupon status
     * @param useStatus 0->unused 1->used
     */
    private void updateCouponStatus(Long couponId,Long memberId,Integer useStatus) {
        if(couponId==null) {
            return;
        }
        //Search first coupon
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus==0?1:0);
        List<SmsCouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(couponHistoryList)) {
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            couponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }

    private void handleRealAmount(List<OmsOrderItem> orderItemList) {
        for(OmsOrderItem orderItem:orderItemList) {
            //Original -promotion - coupon - integration
            BigDecimal realAmount = orderItem.getProductPrice()
                    .subtract(orderItem.getPromotionAmount())
                    .subtract(orderItem.getCouponAmount())
                    .subtract(orderItem.getIntegrationAmount());
            orderItem.setRealAmount(realAmount);
        }
    }

    /**
     * Get order promotion info
     */
    private String getOrderPromotionInfo(List<OmsOrderItem> orderItemList) {
        StringBuilder sb = new StringBuilder();
        for(OmsOrderItem orderItem:orderItemList) {
            sb.append(orderItem.getPromotionName());
            sb.append(";");
        }
        String result = sb.toString();
        if(result.endsWith(";")) {
            result = result.substring(0,result.length()-1);
        }
        return result;
    }

    /**
     * Calculate pay amount
     */
    private BigDecimal calcPayAmount(OmsOrder order) {
        //Total + freight - promotion - coupon - integration
        BigDecimal payAmount = order.getTotalAmount()
                .add(order.getFreightAmount())
                .subtract(order.getPromotionAmount())
                .subtract(order.getCouponAmount())
                .subtract(order.getIntegrationAmount());
        return payAmount;
    }

    /**
     * Calculate order Integration amount
     */
    private BigDecimal calcIntegrationAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal integrationAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getIntegrationAmount() != null) {
                integrationAmount = integrationAmount.add(orderItem.getIntegrationAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return integrationAmount;
    }

    /**
     * Calculate order coupon amount
     */
    private BigDecimal calcCouponAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal couponAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getCouponAmount() != null) {
                couponAmount = couponAmount.add(orderItem.getCouponAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return couponAmount;
    }

    /**
     * Calculate promotion amount
     */
    private BigDecimal calcPromotionAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal promotionAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getPromotionAmount() != null) {
                promotionAmount = promotionAmount.add(orderItem.getPromotionAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return promotionAmount;
    }

    /**
     * Get integration discount
     */
    private BigDecimal getUseIntegrationAmount(Integer useIntegration,BigDecimal totalAmount,UmsMember currentMember,boolean hasCoupon) {
        BigDecimal zeroAmount = new BigDecimal(0);
        //Check if user has enough integration
        if(useIntegration.compareTo(currentMember.getIntegration())>0) {
            return zeroAmount;
        }
        //Check rule
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        if(hasCoupon && integrationConsumeSetting.getCouponStatus().equals(0)) {
            return zeroAmount;
        }
        //If meet min-requirement
        if(useIntegration.compareTo(integrationConsumeSetting.getUseUnit())<0) {
            return zeroAmount;
        }
        //If exceed max percent
        BigDecimal integrationAmount = new BigDecimal(useIntegration).divide(new BigDecimal(integrationConsumeSetting.getUseUnit()), 2, RoundingMode.HALF_EVEN);
        BigDecimal maxPercent = new BigDecimal(integrationConsumeSetting.getMaxPercentPerOrder()).divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        if(integrationAmount.compareTo(totalAmount.multiply(maxPercent))>0) {
            return zeroAmount;
        }
        return integrationAmount;
    }

    /**
     * Handle coupon amount
     */
    private void handleCouponAmount(List<OmsOrderItem> orderItemList,SmsCouponHistoryDetail couponHistoryDetail) {
        SmsCoupon coupon = couponHistoryDetail.getCoupon();
        if(coupon.getUseType().equals(0)) {
            calcPerCouponAmount(orderItemList,coupon);
        } else if (coupon.getUseType().equals(1)) {
            //Specify category
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail,orderItemList,0);
            calcPerCouponAmount(couponOrderItemList,coupon);
        } else if(coupon.getUseType().equals(2)) {
            //Specify product
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail, orderItemList, 1);
            calcPerCouponAmount(couponOrderItemList, coupon);
        }
    }

    /**
     * Cal coupon apply to each product
     */
    private void calcPerCouponAmount(List<OmsOrderItem> orderItemList,SmsCoupon coupon) {
        BigDecimal totalAmount = calcTotalAmount(orderItemList);
        for(OmsOrderItem orderItem:orderItemList) {
            //(product price/total)*coupon
            BigDecimal couponAmount = orderItem.getProductPrice().divide(totalAmount,3,RoundingMode.HALF_EVEN).multiply(coupon.getAmount());
            orderItem.setCouponAmount(couponAmount);
        }
    }

    /**
     * Get coupon related product
     * @param type 0->category 1->product
     */
    private List<OmsOrderItem> getCouponOrderItemByRelation(SmsCouponHistoryDetail couponHistoryDetail,List<OmsOrderItem> orderItemList, int type) {
        List<OmsOrderItem> result = new ArrayList<>();
        if(type == 0) {
            List<Long> categoryIdList = new ArrayList<>();
            for(SmsCouponProductCategoryRelation productCategoryRelation :couponHistoryDetail.getCategoryRelationList()) {
                categoryIdList.add(productCategoryRelation.getProductCategoryId());
            }
            for(OmsOrderItem orderItem:orderItemList) {
                if(categoryIdList.contains(orderItem.getProductCategoryId())){
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        } else if( type == 1) {
            List<Long> productIdList = new ArrayList<>();
            for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                productIdList.add(productRelation.getProductId());
            }
            for (OmsOrderItem orderItem : orderItemList) {
                if (productIdList.contains(orderItem.getProductId())) {
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        }
        return result;
    }

    /**
     * Get use available coupon
     */
    private SmsCouponHistoryDetail getUseCoupon(List<CartPromotionItem> cartPromotionItemList,Long couponId) {
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList,1);
        for(SmsCouponHistoryDetail couponHistoryDetail:couponHistoryDetailList) {
            if(couponHistoryDetail.getCoupon().getId().equals(couponId)){
                return couponHistoryDetail;
            }
        }
        return null;
    }

    /**
     * Calc total amount
     */
    private BigDecimal calcTotalAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal totalAmount = new BigDecimal("0");
        for (OmsOrderItem item : orderItemList) {
            totalAmount = totalAmount.add(item.getProductPrice().multiply(new BigDecimal(item.getProductQuantity())));
        }
        return totalAmount;
    }

    /**
     * Lock order product stock
     */
    private void lockStock(List<CartPromotionItem> cartPromotionItemList) {
        for(CartPromotionItem cartPromotionItem:cartPromotionItemList) {
            PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(cartPromotionItem.getProductSkuId());
            skuStock.setLockStock(skuStock.getLockStock() + cartPromotionItem.getQuantity());
            skuStockMapper.updateByPrimaryKeySelective(skuStock);
        }
    }

    /**
     * Check if order item has stock
     */
    private boolean hasStock(List<CartPromotionItem> cartPromotionItemList) {
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            if (cartPromotionItem.getRealStock()==null||cartPromotionItem.getRealStock() <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculate cart product price
     */
    private ConfirmOrderResult.CalcAmount calcCartAmount(List<CartPromotionItem> cartPromotionItemList) {
        ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
        calcAmount.setFreightAmount(new BigDecimal(0));
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal promotionAmount = new BigDecimal(0);
        for(CartPromotionItem cartPromotionItem :cartPromotionItemList) {
            totalAmount = totalAmount.add(cartPromotionItem.getPrice()).multiply(new BigDecimal(cartPromotionItem.getQuantity()));
            promotionAmount = promotionAmount.add(cartPromotionItem.getReduceAmount().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
        }
        calcAmount.setTotalAmount(totalAmount);
        calcAmount.setPromotionAmount(promotionAmount);
        calcAmount.setPayAmount(totalAmount.subtract(promotionAmount));
        return calcAmount;
    }
}
