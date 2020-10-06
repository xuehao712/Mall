package com.shawn.mall.portal.dao;

import com.shawn.mall.model.SmsCoupon;
import com.shawn.mall.portal.domain.CartProduct;
import com.shawn.mall.portal.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Front end system customize product dao
 */
public interface PortalProductDao {
    /**
     * Get cart product info
     */
    CartProduct getCartProduct(@Param("id") Long id);

    /**
     * Get promotion product info list
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    /**
     * Get available coupon lists
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId") Long productCategoryId);
}
