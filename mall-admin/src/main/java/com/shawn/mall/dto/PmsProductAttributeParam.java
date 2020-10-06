package com.shawn.mall.dto;

import com.shawn.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * product attribute param
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeParam {
    @ApiModelProperty("attribute category ID")
    @NotEmpty(message = "Attribute category cannot be empty")
    private Long productAttributeCategoryId;
    @ApiModelProperty("attribute name")
    @NotEmpty(message = "attribute name cannot be empty")
    private String name;
    @ApiModelProperty("attribute selection：0->unique；1->single；2->multiple")
    @FlagValidator({"0","1","2"})
    private Integer selectType;
    @ApiModelProperty("attribute input type：0->hand；1->select from list")
    @FlagValidator({"0","1"})
    private Integer inputType;
    @ApiModelProperty("input list separate with comma")
    private String inputList;

    private Integer sort;
    @ApiModelProperty("category filter：0->normal；1->color")
    @FlagValidator({"0","1"})
    private Integer filterType;
    @ApiModelProperty("search type；0->no need；1->keyword；2->range search")
    @FlagValidator({"0","1","2"})
    private Integer searchType;
    @ApiModelProperty("same attribute if related；0->no；1->yes")
    @FlagValidator({"0","1"})
    private Integer relatedStatus;
    @ApiModelProperty("if support hand add；0->no；1->yes")
    @FlagValidator({"0","1"})
    private Integer handAddStatus;
    @ApiModelProperty("attribute type；0->specification；1->param")
    @FlagValidator({"0","1"})
    private Integer type;
}
