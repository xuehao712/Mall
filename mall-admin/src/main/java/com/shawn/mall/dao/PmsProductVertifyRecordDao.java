package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * product verify record dao
 */
public interface PmsProductVertifyRecordDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
