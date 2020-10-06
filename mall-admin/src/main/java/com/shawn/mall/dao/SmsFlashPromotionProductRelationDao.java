package com.shawn.mall.dao;

import com.shawn.mall.dto.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * flash and product relation Dao
 */
public interface SmsFlashPromotionProductRelationDao {
    /**
     * Get info
     */
    List<SmsFlashPromotionProduct> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
