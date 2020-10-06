package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * File upload return result
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinioUploadDto {
    @ApiModelProperty("File visit URL")
    private String url;
    @ApiModelProperty("File name")
    private String name;
}
