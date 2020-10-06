package com.shawn.mall.portal.service;

import com.shawn.mall.model.OmsCartItem;
import com.shawn.mall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * Promotion service
 */
public interface OmsPromotionService {
    /**
     * Calculate current cart promotion
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
