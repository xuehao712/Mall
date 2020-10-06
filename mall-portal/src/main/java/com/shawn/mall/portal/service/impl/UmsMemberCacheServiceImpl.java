package com.shawn.mall.portal.service.impl;

import com.shawn.mall.common.service.RedisService;
import com.shawn.mall.mapper.UmsMemberMapper;
import com.shawn.mall.model.UmsMember;
import com.shawn.mall.portal.service.UmsMemberCacheService;
import com.shawn.mall.security.annotation.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * member cache service impl
 */
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;

    @Override
    public void delMember(Long memberId) {
        UmsMember member = memberMapper.selectByPrimaryKey(memberId);
        if(member!=null){
            String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" +member.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UmsMember getMember(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
        return (UmsMember) redisService.get(key);
    }

    @Override
    public void setMember(UmsMember member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
        redisService.set(key, member, REDIS_EXPIRE);
    }

    @CacheException
    @Override
    public void setAuthCode(String email,String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + email;
        redisService.set(key,authCode,REDIS_EXPIRE_AUTH_CODE);
    }

    @CacheException
    @Override
    public String getAuthCode(String email) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + email;
        return (String) redisService.get(key);
    }
}
