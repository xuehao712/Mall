package com.shawn.mall.dao;

import com.shawn.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Coupon and product relation Dao
 */
public interface SmsCouponProductRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
