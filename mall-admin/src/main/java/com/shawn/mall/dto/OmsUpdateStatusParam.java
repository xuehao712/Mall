package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Confirm delivery status params
 */
@Getter
@Setter
public class OmsUpdateStatusParam {
    @ApiModelProperty("serving id")
    private Long id;
    @ApiModelProperty("delivery address related id")
    private Long companyAddressId;
    @ApiModelProperty("confirm return id")
    private BigDecimal returnAmount;
    @ApiModelProperty("handle note")
    private String handleNote;
    @ApiModelProperty("handle staff")
    private String handleMan;
    @ApiModelProperty("receive note")
    private String receiveNote;
    @ApiModelProperty("receiver")
    private String receiveMan;
    @ApiModelProperty("application status：1->returning；2->completed；3->denied")
    private Integer status;
}
