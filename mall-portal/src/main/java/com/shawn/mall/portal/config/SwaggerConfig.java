package com.shawn.mall.portal.config;

import com.shawn.mall.common.config.BaseSwaggerConfig;
import com.shawn.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 API config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shawn.mall.portal.controller")
                .title("mall frontend system")
                .description("mall frontend api document")
                .contactName("Shawn")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
