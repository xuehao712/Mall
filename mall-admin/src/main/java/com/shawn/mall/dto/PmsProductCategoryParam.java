package com.shawn.mall.dto;

import com.shawn.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * product category param
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @ApiModelProperty("parent id")
    private Long parentId;
    @ApiModelProperty(value = "product category name",required = true)
    @NotEmpty(message = "product category name cannot be empty")
    private String name;
    @ApiModelProperty("product unit")
    private String productUnit;
    @ApiModelProperty("if display in nav")
    @FlagValidator(value = {"0","1"},message = "status can only be 0 or 1")
    private Integer navStatus;
    @ApiModelProperty("if display")
    @FlagValidator(value = {"0","1"},message = "status can only be 0 or 1")
    private Integer showStatus;
    @ApiModelProperty("sorting")
    @Min(value = 0,message = "sorting min 0")
    private Integer sort;
    @ApiModelProperty("icon")
    private String icon;
    @ApiModelProperty("keyword")
    private String keywords;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("product related search attribute list")
    private List<Long> productAttributeIdList;
}
