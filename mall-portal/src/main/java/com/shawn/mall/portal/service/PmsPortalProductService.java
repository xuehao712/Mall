package com.shawn.mall.portal.service;

import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.portal.domain.PmsPortalProductDetail;
import com.shawn.mall.portal.domain.PmsProductCategoryNode;

import java.util.List;

/**
 * Front end product service
 */
public interface PmsPortalProductService {
    /**
     * Normal search product
     */
    List<PmsProduct> search(String keyword,Long brandId,Long productCategoryId,Integer pageNum,Integer pageSize,Integer sort);

    /**
     * Tree structure to get product
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * Get product detail
     */
    PmsPortalProductDetail detail(Long id);
}
