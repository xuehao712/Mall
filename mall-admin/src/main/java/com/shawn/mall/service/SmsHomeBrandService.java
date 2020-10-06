package com.shawn.mall.service;

import com.shawn.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home page brand Service
 */
public interface SmsHomeBrandService {
    /**
     * Create
     */
    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * Modify sort
     */
    int updateSort(Long id, Integer sort);

    /**
     * Multiple delete brand
     */
    int delete(List<Long> ids);

    /**
     * Update recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paging search brand
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
