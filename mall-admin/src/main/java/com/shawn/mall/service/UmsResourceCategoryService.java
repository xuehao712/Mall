package com.shawn.mall.service;

import com.shawn.mall.model.UmsResourceCategory;

import java.util.List;

/**
 * Member resource category Service
 */
public interface UmsResourceCategoryService {

    /**
     * Get all resource category
     */
    List<UmsResourceCategory> listAll();

    /**
     * Create
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * Modify
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * Delete
     */
    int delete(Long id);
}
