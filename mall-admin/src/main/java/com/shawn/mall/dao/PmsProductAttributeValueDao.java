package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Product params and attributesDao
 */
public interface PmsProductAttributeValueDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
