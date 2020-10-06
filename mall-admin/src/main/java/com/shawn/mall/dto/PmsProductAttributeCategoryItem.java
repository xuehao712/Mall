package com.shawn.mall.dto;

import com.shawn.mall.model.PmsProductAttribute;
import com.shawn.mall.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * product attribute category dto
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "Product attribute list")
    private List<PmsProductAttribute> productAttributeList;
}
