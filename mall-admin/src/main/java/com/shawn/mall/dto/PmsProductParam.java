package com.shawn.mall.dto;

import com.shawn.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * create and modify product param
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct{
    @ApiModelProperty("product ladder price set")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("product full reduction set")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("product member price set")
    private List<PmsMemberPrice> memberPriceList;
    @ApiModelProperty("product sku stock info")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("product param and specification property")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("subject and product relation")
    private List<CmsSubjectProductRelation> subjectProductRelationList;
    @ApiModelProperty("preference and product relation")
    private List<CmsPreferenceAreaProductRelation> preferenceAreaProductRelationList;
}
