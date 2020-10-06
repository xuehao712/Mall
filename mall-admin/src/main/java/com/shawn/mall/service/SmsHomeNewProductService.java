package com.shawn.mall.service;

import com.shawn.mall.model.SmsHomeNewProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home page new product Service
 */
public interface SmsHomeNewProductService {
    /**
     * Create
     */
    @Transactional
    int create(List<SmsHomeNewProduct> homeNewProductList);

    /**
     * Modify sorting
     */
    int updateSort(Long id, Integer sort);

    /**
     * Multiple delete recommend new
     */
    int delete(List<Long> ids);

    /**
     * Update recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paging search new product
     */
    List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
