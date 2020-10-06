package com.shawn.mall.dao;

import com.shawn.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * Coupon Dao
 */
public interface SmsCouponDao {
    /**
     * Get coupon detail including relation
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
