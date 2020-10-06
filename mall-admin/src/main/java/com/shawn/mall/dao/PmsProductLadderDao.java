package com.shawn.mall.dao;

import com.shawn.mall.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * member ladder price Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductLadderDao {
    /**
     * multiple create
     */
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
