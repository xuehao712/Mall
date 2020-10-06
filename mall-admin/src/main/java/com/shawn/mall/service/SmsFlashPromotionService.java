package com.shawn.mall.service;

import com.shawn.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * Flash promotion Service
 */
public interface SmsFlashPromotionService {
    /**
     * Create
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * Modify flash
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Update status of flash
     */
    int updateStatus(Long id, Integer status);

    /**
     * Get detail
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * Paging event list
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);
}
