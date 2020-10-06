package com.shawn.mall.service;

import com.shawn.mall.dto.PmsProductCategoryParam;
import com.shawn.mall.dto.PmsProductCategoryWithChildrenItem;
import com.shawn.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product category Service
 */
public interface PmsProductCategoryService {
    /**
     * Create
     */
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Modify
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Paging get list
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Get product category base on id
     */
    PmsProductCategory getItem(Long id);

    /**
     * Multiple modify navigation status
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * Multiple modify show status
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * Get product attribute with child
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
