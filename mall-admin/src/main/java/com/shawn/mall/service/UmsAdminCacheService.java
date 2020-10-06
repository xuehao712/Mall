package com.shawn.mall.service;

import com.shawn.mall.model.UmsAdmin;
import com.shawn.mall.model.UmsResource;

import java.util.List;

/**
 * Admin user cache
 */
public interface UmsAdminCacheService {
    /**
     * Delete cache
     */
    void delAdmin(Long adminId);

    /**
     * delete backend resource list cache
     */
    void delResourceList(Long adminId);

    /**
     * When character info change, delete the cache
     */
    void delResourceListByRole(Long roleId);

    /**
     * When character related resource list change, related cache
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * When resource list changed, delete by resource
     */
    void delResourceListByResource(Long resourceId);

    /**
     * Get cache admin info
     */
    UmsAdmin getAdmin(String username);

    /**
     * Set admin cache info
     */
    void setAdmin(UmsAdmin admin);

    /**
     * Get admin resource list
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * Set admin resource list
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);
}
