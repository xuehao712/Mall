package com.shawn.mall.service;

import com.shawn.mall.dto.PmsBrandParam;
import com.shawn.mall.model.PmsBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product brand Service
 */
public interface PmsBrandService {
    /**
     * Get all brands
     */
    List<PmsBrand> listAllBrand();

    /**
     * Create brand
     */
    int createBrand(PmsBrandParam pmsBrandParam);

    /**
     * Modify brand
     */
    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    /**
     * Delete brand
     */
    int deleteBrand(Long id);

    /**
     * Multiple delete brands
     */
    int deleteBrand(List<Long> ids);

    /**
     * Paging search brands
     */
    List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * Get single brand
     */
    PmsBrand getBrand(Long id);

    /**
     * Modify show status
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * Modify factory status
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
