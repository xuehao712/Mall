package com.shawn.mall.dao;

import com.shawn.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * Product Dao
 */
public interface PmsProductDao {
    /**
     * Get product update info
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
