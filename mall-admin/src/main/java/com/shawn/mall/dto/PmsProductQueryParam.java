package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product search query
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductQueryParam {
    @ApiModelProperty("publish status")
    private Integer publishStatus;
    @ApiModelProperty("verify status")
    private Integer verifyStatus;
    @ApiModelProperty("product name keyword search")
    private String keyword;
    @ApiModelProperty("product number")
    private String productSn;
    @ApiModelProperty("product category id")
    private Long productCategoryId;
    @ApiModelProperty("brand id")
    private Long brandId;
}
