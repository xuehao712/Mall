package com.shawn.mall.portal.domain;

import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.model.PmsProductFullReduction;
import com.shawn.mall.model.PmsProductLadder;
import com.shawn.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Product promotion info, include sku, promotional discount, full reduction
 */
@Getter
@Setter
public class PromotionProduct extends PmsProduct {
    //Product stock info
    private List<PmsSkuStock> skuStockList;
    //Product promotion info
    private List<PmsProductLadder> productLadderList;
    //Product full reduction info
    private List<PmsProductFullReduction> productFullReductionList;
}
