package com.shawn.mall.dto;

import com.shawn.mall.model.OmsOrder;
import com.shawn.mall.model.OmsOrderItem;
import com.shawn.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Order detail
 */
@Getter
@Setter
public class OmsOrderDetail extends OmsOrder {

    @ApiModelProperty("Order product list")
    private List<OmsOrderItem> orderItemList;

    @ApiModelProperty("Order operation history")
    private List<OmsOrderOperateHistory> historyList;
}
