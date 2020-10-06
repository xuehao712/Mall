package com.shawn.mall.service;

import com.shawn.mall.dto.SmsFlashPromotionProduct;
import com.shawn.mall.model.SmsFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Flash promotion relation Service
 */
public interface SmsFlashPromotionProductRelationService {
    /**
     * Multiple create
     */
    @Transactional
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * Modify
     */
    int update(Long id, SmsFlashPromotionProductRelation relation);

    /**
     * Delete
     */
    int delete(Long id);

    /**
     * Get detail
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * Paging search info
     *
     * @param flashPromotionId        flash id
     * @param flashPromotionSessionId flash session id
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * Get count
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    long getCount(Long flashPromotionId, Long flashPromotionSessionId);
}
