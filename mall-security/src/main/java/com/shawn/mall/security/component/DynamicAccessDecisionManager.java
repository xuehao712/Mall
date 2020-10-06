package com.shawn.mall.security.component;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * Dynamic access decision, determine if user can access
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
                        Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // Return if config is null
        if(CollUtil.isEmpty(configAttributes)){
            return;
        }
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while(iterator.hasNext()){
            ConfigAttribute configAttribute = iterator.next();
            //Compare visit attribute with user attribute
            String needAuthority = configAttribute.getAttribute();
            for(GrantedAuthority grantedAuthority:authentication.getAuthorities()){
                if(needAuthority.trim().equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }
        throw  new AccessDeniedException("Sorry, you are not authorized to access");
    }
    @Override
    public boolean supports(ConfigAttribute configAttribute){
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass){
        return true;
    }
}
