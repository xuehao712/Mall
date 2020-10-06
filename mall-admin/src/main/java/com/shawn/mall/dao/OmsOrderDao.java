package com.shawn.mall.dao;

import com.shawn.mall.dto.OmsOrderDeliveryParam;
import com.shawn.mall.dto.OmsOrderDetail;
import com.shawn.mall.dto.OmsOrderQueryParam;
import com.shawn.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Order Dao
 * Created by macro on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * Search by param
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * Multiple delivery
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * Get order detail
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
