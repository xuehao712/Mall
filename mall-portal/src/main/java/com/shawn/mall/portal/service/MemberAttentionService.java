package com.shawn.mall.portal.service;

import com.shawn.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;

/**
 * User brand attention service
 */
public interface MemberAttentionService {

    /**
     * Add attention
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * Delete attention
     */
    int delete(Long brandId);

    /**
     * Get user attention list
     */
    Page<MemberBrandAttention> list(Integer pageNum,Integer pageSize);

    /**
     * Get user attention detail
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * Clear all record
     */
    void clear();
}
