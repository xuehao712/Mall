package com.shawn.mall.security.util;

import cn.hutool.core.bean.BeanException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring tool
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    // Get applicationContext
    public static  ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void  setApplicationContext(ApplicationContext applicationContext) throws BeanException{
        if(SpringUtil.applicationContext == null){
            SpringUtil.applicationContext = applicationContext;
        }
    }

    //Get bean through name
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //Get bean through class
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //Return bean base on clazz and name
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
