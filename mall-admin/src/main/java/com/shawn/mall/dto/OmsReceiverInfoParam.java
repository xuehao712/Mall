package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Modify order delivery people info
 */
@Getter
@Setter
public class OmsReceiverInfoParam {
    @ApiModelProperty(value = "Order ID")
    private Long orderId;
    @ApiModelProperty(value = "receiver name")
    private String receiverName;
    @ApiModelProperty(value = "receiver phone")
    private String receiverPhone;
    @ApiModelProperty(value = "receiver email")
    private String receiverEmail;
    @ApiModelProperty(value = "receiver zip code")
    private String receiverZipCode;
    @ApiModelProperty(value = "detail address")
    private String receiverDetailAddress;
    @ApiModelProperty(value = "State")
    private String receiverState;
    @ApiModelProperty(value = "city")
    private String receiverCity;
    @ApiModelProperty(value = "order status：0->unpaid；1->unshipped；2->shipped；3->completed；4->closed；5->invalid")
    private Integer status;
}
