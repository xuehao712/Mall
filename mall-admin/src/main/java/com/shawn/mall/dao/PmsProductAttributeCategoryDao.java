package com.shawn.mall.dao;

import com.shawn.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * product attribute Dao
 * Created by macro on 2018/5/24.
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * Get product attribute category
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
