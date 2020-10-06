package com.shawn.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * Dynamic security related
 */
public interface DynamicSecurityService {
    /**
     * load data source
     */
    Map<String, ConfigAttribute> loadDataSource();
}
