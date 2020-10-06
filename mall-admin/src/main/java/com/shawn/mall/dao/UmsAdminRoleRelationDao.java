package com.shawn.mall.dao;

import com.shawn.mall.model.UmsAdminRoleRelation;
import com.shawn.mall.model.UmsPermission;
import com.shawn.mall.model.UmsResource;
import com.shawn.mall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Admin and role relation Dao
 */
public interface UmsAdminRoleRelationDao {
    /**
     * Multiple insert admin role relation
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * Get all role lists
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * Get role all permission
     */
    List<UmsPermission> getRolePermissionList(@Param("adminId") Long adminId);

    /**
     * Get all permission
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * Admin all resource list
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * Get admin base on resource
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
