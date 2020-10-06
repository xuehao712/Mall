package com.shawn.mall.dao;

import com.shawn.mall.model.UmsPermission;
import com.shawn.mall.model.UmsRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Role permission Dao
 */
public interface UmsRolePermissionRelationDao {
    /**
     * Multiple insert role and permission relation
     */
    int insertList(@Param("list") List<UmsRolePermissionRelation> list);

    /**
     * Get permission base on role
     */
    List<UmsPermission> getPermissionList(@Param("roleId") Long roleId);
}
