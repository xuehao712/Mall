package com.shawn.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Return order application param
 */
@Getter
@Setter
public class OmsOrderReturnApplyParam {
    @ApiModelProperty("order id")
    private Long orderId;
    @ApiModelProperty("return product id")
    private Long productId;
    @ApiModelProperty("order number")
    private String orderSn;
    @ApiModelProperty("member username")
    private String memberUsername;
    @ApiModelProperty("return user name")
    private String returnName;
    @ApiModelProperty("return user phone")
    private String returnEmail;
    @ApiModelProperty("product picture")
    private String productPic;
    @ApiModelProperty("product name")
    private String productName;
    @ApiModelProperty("product brand")
    private String productBrand;
    @ApiModelProperty("product attributes: color:red size:xl")
    private String productAttr;
    @ApiModelProperty("return count")
    private Integer productCount;
    @ApiModelProperty("product price")
    private BigDecimal productPrice;
    @ApiModelProperty("product final price")
    private BigDecimal productRealPrice;
    @ApiModelProperty("reason")
    private String reason;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("evident image, separate with comma")
    private String proofPics;

}
