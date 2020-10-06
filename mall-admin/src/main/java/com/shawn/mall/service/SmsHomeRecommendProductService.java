package com.shawn.mall.service;

import com.shawn.mall.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Hot recommend service
 */
public interface SmsHomeRecommendProductService {
    /**
     * Create
     */
    @Transactional
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    /**
     * Modify sorting
     */
    int updateSort(Long id, Integer sort);

    /**
     * Multiple delete
     */
    int delete(List<Long> ids);

    /**
     * Update recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paging search
     */
    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
