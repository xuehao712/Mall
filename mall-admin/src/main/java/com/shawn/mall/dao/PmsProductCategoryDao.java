package com.shawn.mall.dao;

import com.shawn.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * Dao
 */
public interface PmsProductCategoryDao {
    /**
     * Get product category and child category
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
