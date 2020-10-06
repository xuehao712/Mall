package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order search query
 */
@Getter
@Setter
public class OmsOrderQueryParam {
    @ApiModelProperty(value = "order number")
    private String orderSn;
    @ApiModelProperty(value = "receiver phone/name")
    private String receiverKeyword;
    @ApiModelProperty(value = "order status：0->unpaid；1->unshipped；2->shipped；3->completed；4->closed；5->invalid")
    private Integer status;
    @ApiModelProperty(value = "order type：0->normal；1->flash")
    private Integer orderType;
    @ApiModelProperty(value = "order source：0->PC；1->app")
    private Integer sourceType;
    @ApiModelProperty(value = "order submit time")
    private String createTime;
}
