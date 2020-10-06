package com.shawn.mall.service;

import com.shawn.mall.dto.UmsAdminParam;
import com.shawn.mall.dto.UpdateAdminPasswordParam;
import com.shawn.mall.model.UmsAdmin;
import com.shawn.mall.model.UmsPermission;
import com.shawn.mall.model.UmsResource;
import com.shawn.mall.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Admin service
 */
public interface UmsAdminService {
    /**
     * Get admin base on username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Register
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * Login
     * @param username username
     * @param password password
     * @return generate token
     */
    String login(String username, String password);

    /**
     * Refresh token
     * @param oldToken old token
     */
    String refreshToken(String oldToken);

    /**
     * Get member base on member id
     */
    UmsAdmin getItem(Long id);

    /**
     * Get member base on keyword
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Modify user info
     */
    int update(Long id, UmsAdmin admin);

    /**
     * Delete specify admin
     */
    int delete(Long id);

    /**
     * Modify role relation
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * Get member related to role
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * Get member resource list
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * Modify user permission
     */
    @Transactional
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * Get member all permission
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * Change password
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * Get user info
     */
    UserDetails loadUserByUsername(String username);
}
