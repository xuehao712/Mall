package com.shawn.mall.portal.service;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.portal.domain.ConfirmOrderResult;
import com.shawn.mall.portal.domain.OmsOrderDetail;
import com.shawn.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Front end order service
 */
public interface OmsPortalOrderService {
    /**
     * Form order confirm info base on cartIds
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * Generate order base on order param info
     */
    @Transactional
    Map<String,Object> generateOrder(OrderParam orderParam);

    /**
     * Paid call back
     */
    @Transactional
    Integer paySuccess(Long orderId, Integer payType);

    /**
     * Cancel timeout order
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * Cancel single timeout order
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * Send cancel order delay message
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * Confirm receive
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * Get order list
     */
    CommonPage<OmsOrderDetail> list(Integer status,Integer pageNum,Integer pageSize);

    /**
     * Get order detail base on order id
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * Delete order
     */
    void deleteOrder(Long orderId);
}
