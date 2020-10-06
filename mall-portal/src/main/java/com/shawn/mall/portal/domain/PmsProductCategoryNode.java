package com.shawn.mall.portal.domain;

import com.shawn.mall.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Product category, including child category
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;
}
