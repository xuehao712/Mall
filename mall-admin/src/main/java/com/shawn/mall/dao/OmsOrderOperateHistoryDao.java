package com.shawn.mall.dao;

import com.shawn.mall.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Order operation history Dao
 */
public interface OmsOrderOperateHistoryDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
