package com.shawn.mall.portal.domain;

import com.shawn.mall.model.SmsCoupon;
import com.shawn.mall.model.SmsCouponHistory;
import com.shawn.mall.model.SmsCouponProductCategoryRelation;
import com.shawn.mall.model.SmsCouponProductRelation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Coupon received history detail
 */
@Setter
@Getter
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    //coupon info
    private SmsCoupon coupon;
    //coupon related product
    private List<SmsCouponProductRelation> productRelationList;
    //Coupon related product category
    private List<SmsCouponProductCategoryRelation> categoryRelationList;
}
