package com.shawn.mall.portal.service;

import com.shawn.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * Member service
 */
public interface UmsMemberService {
    /**
     * Get member on username
     */
    UmsMember getByUsername(String username);

    /**
     * Get member on id
     */
    UmsMember getById(Long id);

    /**
     * Member register
     */
    @Transactional
    void register(String username,String password,String telephone,String authCode);

    /**
     * Generate auth
     */
    String generateAuthCode(String email);

    /**
     * Change password
     */
    @Transactional
    void updatePassword(String email,String password,String authCode);

    /**
     * Get current member;
     */
    UmsMember getCurrentMember();

    /**
     * Modify integration base on user id
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * Get user info
     */
    UserDetails loadUserByUsername(String username);

    /**
     * Get token after login
     */
    String login(String username,String password);

    /**
     * Refresh token
     */
    String refreshToken(String token);

}
