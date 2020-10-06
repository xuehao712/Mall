package com.shawn.mall.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Controller level log domain
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WebLog {
    /**
     * Operation description
     */
    private String description;
    /**
     * Operation user
     */
    private String username;
    /**
     *  Operation time
     */
    private Long startTime;
    /**
     * Spent time
     */
    private Integer spendTime;
    /**
     *  Base path
     */
    private String basePath;
    /**
     * Uri
     */
    private String uri;
    /**
     * Url
     */
    private String url;
    /**
     * Request method
     */
    private String method;
    /**
     * IP address
     */
    private String ip;
    /**
     * Request config
     */
    private Object parameter;
    /**
     * Result
     */
    private Object result;
}
