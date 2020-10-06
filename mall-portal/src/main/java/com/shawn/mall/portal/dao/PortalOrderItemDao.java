package com.shawn.mall.portal.dao;

import com.shawn.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Order product info customize Dao
 */
public interface PortalOrderItemDao {
    /**
     * insert multiple
     */
    int insertList(@Param("list") List<OmsOrderItem> list);
}
