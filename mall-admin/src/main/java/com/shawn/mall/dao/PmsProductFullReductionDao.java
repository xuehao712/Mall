package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * product full reduction Dao
 */
public interface PmsProductFullReductionDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
