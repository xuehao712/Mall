package com.shawn.mall.security.annotation;

import java.lang.annotation.*;
/**
 * Annotation cache annotation exception
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
