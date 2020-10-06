package com.shawn.mall.portal.service;

import com.shawn.mall.model.UmsMember;

/**
 * Member info cache
 */
public interface UmsMemberCacheService {
    /**
     * Delete member cache
     */
    void delMember(Long memberId);

    /**
     * Get member cache
     */
    UmsMember getMember(String username);

    /**
     * Set member cache
     */
    void setMember(UmsMember member);

    /**
     * Set Auth
     */
    void setAuthCode(String telephone,String authCode);

    /**
     * Get auth
     */
    String getAuthCode(String email);
}
