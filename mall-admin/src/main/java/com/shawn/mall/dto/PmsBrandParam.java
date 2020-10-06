package com.shawn.mall.dto;

import com.shawn.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Band param
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandParam {
    @ApiModelProperty(value = "brand name",required = true)
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @ApiModelProperty(value = "brand first character")
    private String firstLetter;
    @ApiModelProperty(value = "sorting")
    @Min(value = 0, message = "sorting min 0")
    private Integer sort;
    @ApiModelProperty(value = "whether factory")
    @FlagValidator(value = {"0","1"}, message = "factory status not correct")
    private Integer factoryStatus;
    @ApiModelProperty(value = "Whether display")
    @FlagValidator(value = {"0","1"}, message = "Display status not correct")
    private Integer showStatus;
    @ApiModelProperty(value = "brand logo",required = true)
    @NotEmpty(message = "Brand logo cannot be empty")
    private String logo;
    @ApiModelProperty(value = "brand big picture")
    private String bigPic;
    @ApiModelProperty(value = "brand story")
    private String brandStory;
}
