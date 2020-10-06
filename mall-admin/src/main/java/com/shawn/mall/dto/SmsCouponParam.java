package com.shawn.mall.dto;

import com.shawn.mall.model.SmsCoupon;
import com.shawn.mall.model.SmsCouponProductCategoryRelation;
import com.shawn.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Coupon info ,including binding product and category
 */
public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("coupon related product")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("coupon related product category")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
