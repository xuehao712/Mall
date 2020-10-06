package com.shawn.mall.portal.domain;

import com.shawn.mall.model.OmsCartItem;

import java.math.BigDecimal;

/**
 * Cart promotion info
 */
public class CartPromotionItem extends OmsCartItem {
    //Promotion message
    private String promotionMessage;
    //Promotion reduce amount
    private BigDecimal reduceAmount;
    //Product actual stock ( left - locked)
    private Integer realStock;
    //Integration gain from product
    private Integer integration;
    //Growth grain from product
    private Integer growth;

    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}
