package com.shawn.mall.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.shawn.mall.common.exception.Asserts;
import com.shawn.mall.mapper.*;
import com.shawn.mall.model.*;
import com.shawn.mall.portal.dao.SmsCouponHistoryDao;
import com.shawn.mall.portal.domain.CartPromotionItem;
import com.shawn.mall.portal.domain.SmsCouponHistoryDetail;
import com.shawn.mall.portal.service.UmsMemberCouponService;
import com.shawn.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.utilities.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Member coupon service impl
 */
@Service
public class UmsMemberCouponServiceImpl implements UmsMemberCouponService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public void add(Long couponId) {
        UmsMember currentMember = memberService.getCurrentMember();
        //Get coupon info, determine quantity
        SmsCoupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if(coupon == null) {
            Asserts.fail("Coupons do not exist");
        }
        if(coupon.getCount()<=0) {
            Asserts.fail("This coupon is not available");
        }
        Date now = new Date();
        if(now.before(coupon.getEnableTime())) {
            Asserts.fail("Coupon is not yet available");
        }
        //Determine if member receive coupon quantity
        SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
        couponHistoryExample.createCriteria().andCouponIdEqualTo(couponId).andMemberIdEqualTo(currentMember.getId());
        long count = couponHistoryMapper.countByExample(couponHistoryExample);
        if(count>=coupon.getPerLimit()){
            Asserts.fail("You have already received this coupon");
        }
        //Generate receive coupon history
        SmsCouponHistory couponHistory = new SmsCouponHistory();
        couponHistory.setCouponId(couponId);
        couponHistory.setCouponCode(generateCouponCode(currentMember.getId()));
        couponHistory.setCreateTime(now);
        couponHistory.setMemberId(currentMember.getId());
        couponHistory.setMemberNickname(currentMember.getNickname());
        //Get type
        couponHistory.setGetType(1);
        //Set unused
        couponHistory.setUseStatus(0);
        couponHistoryMapper.insert(couponHistory);
        //Modify coupon tale quantity
        coupon.setCount(coupon.getCount()-1);
        coupon.setReceiveCount(coupon.getReceiveCount()==null?1:coupon.getReceiveCount()+1);
        couponMapper.updateByPrimaryKey(coupon);
    }

    /**
     * 16 coupon number generate timestamp last 8 digits + 4 random + user id last 4 digits
     */
    private String generateCouponCode(Long memberId) {
        StringBuilder sb = new StringBuilder();
        Long currentTimeMillis = System.currentTimeMillis();
        String timeMillisStr = currentTimeMillis.toString();
        sb.append(timeMillisStr.substring(timeMillisStr.length()-8));
        for(int i = 0;i<4;i++) {
            sb.append(new Random().nextInt(10));
        }
        String memberIdStr = memberId.toString();
        if(memberIdStr.length()<=4){
            sb.append(String.format("%04d", memberId));
        } else {
            sb.append(memberIdStr.substring(memberIdStr.length()-4));
        }
        return sb.toString();
    }

    @Override
    public List<SmsCouponHistory> listHistory(Integer useStatus) {
        UmsMember member = memberService.getCurrentMember();
        SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = couponHistoryExample.createCriteria();
        criteria.andMemberIdEqualTo(member.getId());
        if(useStatus!=null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        return couponHistoryMapper.selectByExample(couponHistoryExample);
    }

    @Override
    public List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList,Integer type) {
        UmsMember member = memberService.getCurrentMember();
        Date now = new Date();
        //Get user all coupons
        List<SmsCouponHistoryDetail> allList = couponHistoryDao.getDetailList(member.getId());
        //Check if coupon is valid
        List<SmsCouponHistoryDetail> enableList = new ArrayList<>();
        List<SmsCouponHistoryDetail> disableList = new ArrayList<>();
        for(SmsCouponHistoryDetail couponHistoryDetail:allList) {
            Integer useType = couponHistoryDetail.getCoupon().getUseType();
            BigDecimal minPoint = couponHistoryDetail.getCoupon().getMinPoint();
            Date endTime = couponHistoryDetail.getCoupon().getEndTime();
            if(useType.equals(0)){
                //0->All product
                BigDecimal totalAmount = calcTotalAmount(cartItemList);
                if(now.before(endTime) && totalAmount.subtract(minPoint).intValue()>=0) {
                    enableList.add(couponHistoryDetail);
                } else {
                    disableList.add(couponHistoryDetail);
                }
            } else if(useType.equals(1)) {
                //1-> specify category
                List<Long> productCategoryIds = new ArrayList<>();
                for(SmsCouponProductCategoryRelation categoryRelation:couponHistoryDetail.getCategoryRelationList()){
                    productCategoryIds.add(categoryRelation.getProductCategoryId());
                }
                BigDecimal totalAmount = calcTotalAmountByProductCategoryId(cartItemList,productCategoryIds);
                if(now.before(endTime) && totalAmount.intValue()>0 &&totalAmount.subtract(minPoint).intValue()>=0) {
                    enableList.add(couponHistoryDetail);
                }else {
                    disableList.add(couponHistoryDetail);
                }
            } else if(useType.equals(2)){
                //2->specify product
                List<Long> productIds = new ArrayList<>();
                for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                    productIds.add(productRelation.getProductId());
                }
                BigDecimal totalAmount = calcTotalAmountByProductId(cartItemList,productIds);
                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }
        }
        if(type.equals(1)){
            return enableList;
        }else{
            return disableList;
        }
    }

    @Override
    public List<SmsCoupon> listByProduct(Long productId) {
        List<Long> allCouponIds = new ArrayList<>();
        //Get product coupon
        SmsCouponProductRelationExample cprExample = new SmsCouponProductRelationExample();
        cprExample.createCriteria().andProductIdEqualTo(productId);
        List<SmsCouponProductRelation> cprList = couponProductRelationMapper.selectByExample(cprExample);
        if(CollUtil.isNotEmpty(cprList)){
            List<Long> couponIds = cprList.stream().map(SmsCouponProductRelation::getCouponId).collect(Collectors.toList());;
            allCouponIds.addAll(couponIds);
        }
        //Get category coupon
        PmsProduct product = productMapper.selectByPrimaryKey(productId);
        SmsCouponProductCategoryRelationExample cpcrExample = new SmsCouponProductCategoryRelationExample();
        cpcrExample.createCriteria().andProductCategoryIdEqualTo(product.getProductCategoryId());
        List<SmsCouponProductCategoryRelation> cpcrList = couponProductCategoryRelationMapper.selectByExample(cpcrExample);
        if(CollUtil.isNotEmpty(cpcrList)){
            List<Long> couponIds = cpcrList.stream().map(SmsCouponProductCategoryRelation::getCouponId).collect(Collectors.toList());
            allCouponIds.addAll(couponIds);
        }
        if(CollUtil.isEmpty(allCouponIds)){
            return new ArrayList<>();
        }
        //All coupons
        SmsCouponExample couponExample = new SmsCouponExample();
        couponExample.createCriteria().andEndTimeGreaterThan(new Date())
                .andStartTimeLessThan(new Date())
                .andUseTypeEqualTo(0);
        couponExample.or(couponExample.createCriteria()
                .andEndTimeGreaterThan(new Date())
                .andStartTimeLessThan(new Date())
                .andUseTypeNotEqualTo(0)
                .andIdIn(allCouponIds));
        return couponMapper.selectByExample(couponExample);
    }

    @Override
    public List<SmsCoupon> list(Integer useStatus) {
        UmsMember member = memberService.getCurrentMember();
        return couponHistoryDao.getCouponList(member.getId(),useStatus);
    }

    private BigDecimal calcTotalAmount(List<CartPromotionItem> cartItemList) {
        BigDecimal total = new BigDecimal(0);
        for(CartPromotionItem promotionItem:cartItemList) {
            BigDecimal realprice = promotionItem.getPrice().subtract(promotionItem.getReduceAmount());
            total = total.add(realprice.multiply(new BigDecimal(promotionItem.getQuantity())));
        }
        return total;
    }

    private BigDecimal calcTotalAmountByProductCategoryId(List<CartPromotionItem> cartItemList,List<Long> productCategoryIds){
        BigDecimal total = new BigDecimal(0);
        for(CartPromotionItem promotionItem:cartItemList) {
            if(productCategoryIds.contains(promotionItem.getProductCategoryId())){
                BigDecimal realPrice = promotionItem.getPrice().subtract(promotionItem.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(promotionItem.getQuantity())));
            }
        }
        return total;
    }

    private BigDecimal calcTotalAmountByProductId(List<CartPromotionItem> cartItemList,List<Long> productIds) {
        BigDecimal total = new BigDecimal(0);
        for (CartPromotionItem item : cartItemList) {
            if(productIds.contains(item.getProductId())){
                BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
            }
        }
        return total;
    }
}
