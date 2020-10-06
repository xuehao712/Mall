package com.shawn.mall.service;

import com.shawn.mall.dto.PmsProductParam;
import com.shawn.mall.dto.PmsProductQueryParam;
import com.shawn.mall.dto.PmsProductResult;
import com.shawn.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product service
 */
public interface PmsProductService {
    /**
     * Create
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * Get update info base on id
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * Modify
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * Paging search product
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * Multiple modify verify status
     * @param ids product id
     * @param verifyStatus verify status
     * @param detail verify detail
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * Multiple modify product publish status
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * Multiple modify recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Multiple modify new status
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * Multiple modify delete status
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * Get product base on keyword
     */
    List<PmsProduct> list(String keyword);
}
