package com.shawn.mall.dao;

import com.shawn.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Coupon and product category relation dao
 */
public interface SmsCouponProductCategoryRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
