package com.shawn.mall.dao;

import com.shawn.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    /**
     * Get product category and child category
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
