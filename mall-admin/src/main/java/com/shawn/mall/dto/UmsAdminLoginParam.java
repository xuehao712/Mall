package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Admin login param
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "username", required = true)
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @ApiModelProperty(value = "password", required = true)
    @NotEmpty(message = "password cannot be empty")
    private String password;
}
