package com.shawn.mall.common.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Swagger customize config
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class SwaggerProperties {
    /**
     * Api doc url
     */
    private String apiBasePackage;
    /**
     * Security verify
     */
    private boolean enableSecurity;
    /**
     * Doc title
     */
    private String title;
    /**
     * Doc description
     */
    private String description;
    /**
     * Doc version
     */
    private String version;
    /**
     * Doc contact name
     */
    private String contactName;
    /**
     * Doc contact url
     */
    private String contactUrl;
    /**
     * Doc contact email
     */
    private String contactEmail;
}
