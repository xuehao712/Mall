package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Modify order money info param
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    @ApiModelProperty("Order ID")
    private Long orderId;
    @ApiModelProperty("Freight amount")
    private BigDecimal freightAmount;
    @ApiModelProperty("Admin discount amount")
    private BigDecimal discountAmount;
    @ApiModelProperty("Order status：0->unpaid；1->unshipped；2->shipped；3->completed；4->closed；5->invalid")
    private Integer status;
}
