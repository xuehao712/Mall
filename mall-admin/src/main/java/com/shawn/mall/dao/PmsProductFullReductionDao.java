package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * product full reduction Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductFullReductionDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
