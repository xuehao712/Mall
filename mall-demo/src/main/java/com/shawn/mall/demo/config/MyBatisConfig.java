package com.shawn.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis Config
 */
@Configuration
@MapperScan("com.shawn.mall.mapper")
public class MyBatisConfig {
}
