package com.shawn.mall.service;

import com.shawn.mall.dto.OssCallbackResult;
import com.shawn.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss upload Service
 */
public interface OssService {
    /**
     * oss upload generate
     */
    OssPolicyResult policy();
    /**
     * oss upload success callback
     */
    OssCallbackResult callback(HttpServletRequest request);
}
