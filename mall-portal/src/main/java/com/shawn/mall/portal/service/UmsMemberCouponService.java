package com.shawn.mall.portal.service;

import com.shawn.mall.model.SmsCoupon;
import com.shawn.mall.model.SmsCouponHistory;
import com.shawn.mall.portal.domain.CartPromotionItem;
import com.shawn.mall.portal.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Member coupon service
 */
public interface UmsMemberCouponService {
    /**
     * Member add coupon
     */
    @Transactional
    void add(Long couponId);

    /**
     * Get coupon history list
     */
    List<SmsCouponHistory> listHistory(Integer useStatus);

    /**
     * Get available coupon base on cart info
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList,Integer type);

    /**
     * Get current product related coupon
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * Get member coupon list
     */
    List<SmsCoupon> list(Integer useStatus);
}
