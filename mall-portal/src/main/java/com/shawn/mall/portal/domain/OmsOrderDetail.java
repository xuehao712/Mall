package com.shawn.mall.portal.domain;

import com.shawn.mall.model.OmsOrder;
import com.shawn.mall.model.OmsOrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Product info order detail
 */
@Getter
@Setter
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;
}
