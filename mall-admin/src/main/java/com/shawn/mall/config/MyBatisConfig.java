package com.shawn.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis related
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.shawn.mall.mapper","com.shawn.mall.dao"})
public class MyBatisConfig {
}
