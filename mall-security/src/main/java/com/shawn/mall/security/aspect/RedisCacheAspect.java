package com.shawn.mall.security.aspect;

import com.shawn.mall.security.annotation.CacheException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis cache aspect, prevent Redis shutdown to affect business logic
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Pointcut("execution(public * com.shawn.mall.portal.service.*CacheService.*(..))||execution(public * com.shawn.mall.service.*CacheService.*(..))")
    public void cacheAspect(){
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try{
            result = joinPoint.proceed();
        } catch (Throwable throwable){
            // CacheException annotation method throw exception
            if(method.isAnnotationPresent(CacheException.class)){
                throw  throwable;
            }else {
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }
}
