package com.shawn.mall.dao;

import com.shawn.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * product attribute Dao
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * Get product attribute category
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
