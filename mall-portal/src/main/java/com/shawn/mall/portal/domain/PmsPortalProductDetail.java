package com.shawn.mall.portal.domain;

import com.shawn.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * front end side product info
 */
@Getter
@Setter
public class PmsPortalProductDetail {
    @ApiModelProperty("product info")
    private PmsProduct product;
    @ApiModelProperty("product brand")
    private PmsBrand brand;
    @ApiModelProperty("product attributes and params")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("hand on input product attributes and params")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("product sku stock info")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("product ladder price setting")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("product full reduction")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("product coupon list")
    private List<SmsCoupon> couponList;

}
