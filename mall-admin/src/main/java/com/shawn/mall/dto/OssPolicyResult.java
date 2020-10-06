package com.shawn.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取OSS上传文件授权返回结果
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssPolicyResult {
    @ApiModelProperty("member flag to access auth")
    private String accessKeyId;
    @ApiModelProperty("Member form upload policy,base64 encoded string")
    private String policy;
    @ApiModelProperty("policy signature")
    private String signature;
    @ApiModelProperty("upload folder prefix")
    private String dir;
    @ApiModelProperty("oss view host")
    private String host;
    @ApiModelProperty("upload success call back param")
    private String callback;
}
