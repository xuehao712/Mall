package com.shawn.mall.dao;

import com.shawn.mall.model.UmsMenu;
import com.shawn.mall.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Role Dao
 */
public interface UmsRoleDao {
    /**
     * Get menu base on admin id
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * Get menu base on role id
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * Get resource base on roleid
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
