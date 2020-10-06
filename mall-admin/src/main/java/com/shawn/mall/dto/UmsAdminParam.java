package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Member login param
 */
@Getter
@Setter
public class UmsAdminParam {
    @ApiModelProperty(value = "username", required = true)
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @ApiModelProperty(value = "password", required = true)
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @ApiModelProperty(value = "member icon")
    private String icon;
    @ApiModelProperty(value = "email")
    @Email(message = "email format is not correct")
    private String email;
    @ApiModelProperty(value = "user nickname")
    private String nickName;
    @ApiModelProperty(value = "note")
    private String note;
}
