package com.shawn.mall.portal.service;

import com.shawn.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Member product save service
 */
public interface MemberCollectionService {
    /**
     * Add collection
     */
    int add(MemberProductCollection productCollection);

    /**
     * Delete collection
     */
    int delete(Long productId);

    /**
     * Get collection list
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * Get collection detail
     */
    MemberProductCollection detail(Long productId);

    /**
     * Clear all
     */
    void clear();
}
