package com.shawn.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis related config
 */
@Configuration
@MapperScan({"com.shawn.mall.mapper","com.shawn.mall.search.dao"})
public class MyBatisConfig {
}
