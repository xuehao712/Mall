package com.shawn.mall.service;

import com.shawn.mall.dto.UmsPermissionNode;
import com.shawn.mall.model.UmsPermission;

import java.util.List;

/**
 * Member permission service
 */
public interface UmsPermissionService {
    /**
     * Create permission
     */
    int create(UmsPermission permission);

    /**
     * Modify permission
     */
    int update(Long id, UmsPermission permission);

    /**
     * Multiple delete permission
     */
    int delete(List<Long> ids);

    /**
     * Treelist to get all permission
     */
    List<UmsPermissionNode> treeList();

    /**
     * Get all permission
     */
    List<UmsPermission> list();
}
