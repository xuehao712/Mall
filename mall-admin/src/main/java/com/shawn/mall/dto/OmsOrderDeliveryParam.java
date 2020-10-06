package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order delivery param
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {
    @ApiModelProperty("Order id")
    private Long orderId;
    @ApiModelProperty("Freight company")
    private String deliveryCompany;
    @ApiModelProperty("shipping number")
    private String deliverySn;
}
