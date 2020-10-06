package com.shawn.mall.dao;

import com.shawn.mall.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * member price Dao
 */
public interface PmsMemberPriceDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
