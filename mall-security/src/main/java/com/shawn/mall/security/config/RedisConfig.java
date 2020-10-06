package com.shawn.mall.security.config;

import com.shawn.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis Config
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
