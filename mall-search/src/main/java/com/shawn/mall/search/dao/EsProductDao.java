package com.shawn.mall.search.dao;

import com.shawn.mall.search.domain.EsProduct;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Search items Dao
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
