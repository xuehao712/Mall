package com.shawn.mall.service;

import com.shawn.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * Coupon receive Service
 */
public interface SmsCouponHistoryService {
    /**
     * Paging get coupon history list
     * @param couponId coupon id
     * @param useStatus use status
     * @param orderSn order number
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
