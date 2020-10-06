package com.shawn.mall.search.config;

import com.shawn.mall.common.config.BaseSwaggerConfig;
import com.shawn.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API doc config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties(){
        return SwaggerProperties.builder()
                .apiBasePackage("com.shawn.mall.search.controller")
                .title("mall search system")
                .description("mall search related api document")
                .contactName("Shawn")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
