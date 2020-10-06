package com.shawn.mall.portal.service;

import com.shawn.mall.model.OmsCartItem;
import com.shawn.mall.portal.domain.CartProduct;
import com.shawn.mall.portal.domain.CartPromotionItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Cart service
 */
public interface OmsCartItemService {
    /**
     * Search if card contail product,yes add quantity, no add to cart
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * Get cart list base on memberId
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * Get promotion info cart list
     */
    List<CartPromotionItem> listPromotion(Long memberId,List<Long> cartIds);

    /**
     * Modify product quantity
     */
    int updateQuantity(Long id,Long memberId,Integer quantity);

    /**
     * Delete multiple products
     */
    int delete(Long memberId,List<Long> ids);

    /**
     * Get cart product items
     */
    CartProduct getCartProduct(Long productId);

    /**
     * Modify shopping cart attribute
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * Clear cart
     */
    int clear(Long memberId);
}
