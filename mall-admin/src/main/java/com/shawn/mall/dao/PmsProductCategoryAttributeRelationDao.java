package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Product attribute and category relation Dao
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
