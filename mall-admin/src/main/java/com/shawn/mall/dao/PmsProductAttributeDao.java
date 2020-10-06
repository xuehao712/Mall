package com.shawn.mall.dao;

import com.shawn.mall.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Product attribute Dao
 */
public interface PmsProductAttributeDao {
    /**
     * Get product attribute info
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
