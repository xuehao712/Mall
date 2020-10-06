package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order return application query search
 */
@Getter
@Setter
public class OmsReturnApplyQueryParam {
    @ApiModelProperty("application id")
    private Long id;
    @ApiModelProperty(value = "receiver phone,name,email")
    private String receiverKeyword;
    @ApiModelProperty(value = "application status：0->unsolved；1->returning；2->completed；3->denied")
    private Integer status;
    @ApiModelProperty(value = "apply time")
    private String createTime;
    @ApiModelProperty(value = "handle staff")
    private String handleMan;
    @ApiModelProperty(value = "handle time")
    private String handleTime;
}
