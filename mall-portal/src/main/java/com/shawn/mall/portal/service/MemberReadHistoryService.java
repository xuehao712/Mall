package com.shawn.mall.portal.service;

import com.shawn.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Member history service
 */
public interface MemberReadHistoryService {
    /**
     * Generate record
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * Delete multiple records
     */
    int delete(List<String> ids);

    /**
     * Get history
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * Clear all history
     */
    void clear();
}
