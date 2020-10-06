package com.shawn.mall.service;

import com.shawn.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * Member level Service
 */
public interface UmsMemberLevelService {
    /**
     * Get all login members
     * @param defaultStatus If default member
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
