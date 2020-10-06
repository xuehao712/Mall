package com.shawn.mall.demo.config;

import com.shawn.mall.common.config.BaseSwaggerConfig;
import com.shawn.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger related config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shawn.mall.demo.controller")
                .title("mall-demo system")
                .description("SpringBoot demo")
                .contactName("shawn")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
