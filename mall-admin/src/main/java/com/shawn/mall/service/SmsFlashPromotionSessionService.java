package com.shawn.mall.service;

import com.shawn.mall.dto.SmsFlashPromotionSessionDetail;
import com.shawn.mall.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * Flash session Service
 */
public interface SmsFlashPromotionSessionService {
    /**
     * Create
     */
    int create(SmsFlashPromotionSession promotionSession);

    /**
     * Modify
     */
    int update(Long id, SmsFlashPromotionSession promotionSession);

    /**
     * Modify status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Get detail
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * Get list base on status
     */
    List<SmsFlashPromotionSession> list();

    /**
     * Get all available session and list
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
