package com.shawn.mall.portal.dao;

import com.shawn.mall.model.OmsOrderItem;
import com.shawn.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Front end portal customize dao
 */
public interface PortalOrderDao {
    /**
     * Get order and order product details
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * Modify
     */
    int updateSkuStock(@Param("itemList")List<OmsOrderItem> orderItemList);

    /**
     * Get expired order
     */
    List<OmsOrderDetail> getTimeOutOrder(@Param("minutes") Integer minute);

    /**
     * modify multiple order status
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * unlock order stock lock
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);
}
