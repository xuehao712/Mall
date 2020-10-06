package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * oss upload success callback
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackParam {
    @ApiModelProperty("Call back url")
    private String callbackUrl;
    @ApiModelProperty("Request params callback")
    private String callbackBody;
    @ApiModelProperty("form submit type")
    private String callbackBodyType;
}
