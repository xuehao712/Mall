package com.shawn.mall.service;

import com.shawn.mall.dto.PmsProductAttributeCategoryItem;
import com.shawn.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * Product attribute category Service
 */
public interface PmsProductAttributeCategoryService {
    /**
     * Create attribute
     */
    int create(String name);

    /**
     * Modify
     */
    int update(Long id, String name);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Get single detail
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * Paging search list
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * Get list with attributes
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
