package com.shawn.mall.portal.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Flash promotion and product
 */
@Getter
@Setter
public class FlashPromotionProduct {
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
