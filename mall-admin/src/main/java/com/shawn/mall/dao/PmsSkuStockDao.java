package com.shawn.mall.dao;

import com.shawn.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Product sku dao
 */
public interface PmsSkuStockDao {
    /**
     * Multiple insert
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);

    /**
     * Multiple replace
     */
    int replaceList(@Param("list") List<PmsSkuStock> skuStockList);
}
