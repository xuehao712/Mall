package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Modify password
 */
@Getter
@Setter
public class UpdateAdminPasswordParam {
    @ApiModelProperty(value = "username", required = true)
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @ApiModelProperty(value = "old password", required = true)
    @NotEmpty(message = "old password cannot be empty")
    private String oldPassword;
    @ApiModelProperty(value = "new password", required = true)
    @NotEmpty(message = "new password cannot be empty")
    private String newPassword;
}
