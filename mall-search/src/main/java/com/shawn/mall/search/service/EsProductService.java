package com.shawn.mall.search.service;

import com.shawn.mall.search.domain.EsProduct;
import com.shawn.mall.search.domain.EsProductRelatedInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Search product management service
 */
public interface EsProductService {
    /**
     * Import all products to es
     */
    int importAll();

    /**
     * Delete product base on id
     */
    void delete(Long id);

    /**
     * Create product base on id
     */
    EsProduct create(Long id);

    /**
     * Delete multiple products
     */
    void delete(List<Long> ids);

    /**
     * Search by keywords or subtitle
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * Search by keywords or subtitle
     */
    Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort);

    /**
     * Recommend base on product id
     */
    Page<EsProduct> recommend(Long id,Integer pageNum, Integer pageSize);

    /**
     * Search related info, brand, sort, attribute
     */
    EsProductRelatedInfo searchRelatedInfo(String keyword);
}
