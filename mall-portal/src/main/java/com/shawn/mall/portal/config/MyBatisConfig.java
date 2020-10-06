package com.shawn.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis config
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.shawn.mall.mapper","com.shawn.mall.portal.dao"})
public class MyBatisConfig {
}
