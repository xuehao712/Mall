package com.shawn.mall.dto;

import com.shawn.mall.model.UmsPermission;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * backend permission node
 */
public class UmsPermissionNode extends UmsPermission {
    @Getter
    @Setter
    @ApiModelProperty(value = "child permission")
    private List<UmsPermissionNode> children;
}
