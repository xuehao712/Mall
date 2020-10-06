package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * oss upload file call back result
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @ApiModelProperty("file name")
    private String filename;
    @ApiModelProperty("file size")
    private String size;
    @ApiModelProperty("file mimeType")
    private String mimeType;
    @ApiModelProperty("picture file width")
    private String width;
    @ApiModelProperty("picture file height")
    private String height;
}
