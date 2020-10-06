package com.shawn.mall.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product category corresponding attribute
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductAttrInfo {
    @ApiModelProperty("product attribute id")
    private Long attributeId;
    @ApiModelProperty("attribute category id")
    private Long attributeCategoryId;
}
