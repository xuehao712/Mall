package com.shawn.mall.service;

import com.shawn.mall.model.PmsSkuStock;

import java.util.List;

/**
 * sku stock Service
 */
public interface PmsSkuStockService {
    /**
     * Get list base on product id and key word
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * Multiple update product stock
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}
