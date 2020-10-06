package com.shawn.mall.service;

import com.shawn.mall.model.UmsMenu;
import com.shawn.mall.model.UmsPermission;
import com.shawn.mall.model.UmsResource;
import com.shawn.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Admin role Service
 */
public interface UmsRoleService {
    /**
     * Create
     */
    int create(UmsRole role);

    /**
     * Modify
     */
    int update(Long id, UmsRole role);

    /**
     * Multiple delete role
     */
    int delete(List<Long> ids);

    /**
     * Get single role permission
     */
    List<UmsPermission> getPermissionList(Long roleId);

    /**
     * Modify single role permission
     */
    @Transactional
    int updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * Get all role list
     */
    List<UmsRole> list();

    /**
     * Paging get role list
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Get menu base on admin id
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * Get role related menu
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * Get role related resource
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * Assign menu to role
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * Assign role resource
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
