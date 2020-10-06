package com.shawn.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Params when form order
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderParam {
    @ApiModelProperty("receiver address id")
    private Long memberReceiveAddressId;
    @ApiModelProperty("coupon id")
    private Long couponId;
    @ApiModelProperty("used integration")
    private Integer useIntegration;
    @ApiModelProperty("paid method")
    private Integer payType;
    @ApiModelProperty("selected cart product id")
    private List<Long> cartIds;
}
