package com.shawn.mall.config;

import com.shawn.mall.common.config.BaseSwaggerConfig;
import com.shawn.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Api
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shawn.mall.controller")
                .title("mall admin system")
                .description("mall admin related api")
                .contactName("shawn")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
