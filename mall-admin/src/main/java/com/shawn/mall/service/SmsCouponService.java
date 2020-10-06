package com.shawn.mall.service;

import com.shawn.mall.dto.SmsCouponParam;
import com.shawn.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Coupon service
 */
public interface SmsCouponService {
    /**
     * Create
     */
    @Transactional
    int create(SmsCouponParam couponParam);

    /**
     * Delete coupon
     */
    @Transactional
    int delete(Long id);

    /**
     * Update coupon
     */
    @Transactional
    int update(Long id, SmsCouponParam couponParam);

    /**
     * Paging get coupon list
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * Get coupon detail
     * @param id coupon id
     */
    SmsCouponParam getItem(Long id);
}
