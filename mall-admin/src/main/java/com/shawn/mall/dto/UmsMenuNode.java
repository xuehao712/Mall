package com.shawn.mall.dto;

import com.shawn.mall.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * backend menu node
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "child menu")
    private List<UmsMenuNode> children;
}
