package com.shawn.mall.service;

import com.shawn.mall.model.UmsResource;

import java.util.List;

/**
 * Admin resource service
 */
public interface UmsResourceService {
    /**
     * Create
     */
    int create(UmsResource umsResource);

    /**
     * Modify
     */
    int update(Long id, UmsResource umsResource);

    /**
     * Get resource detail
     */
    UmsResource getItem(Long id);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Paging search resource
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * Search all resources
     */
    List<UmsResource> listAll();
}
