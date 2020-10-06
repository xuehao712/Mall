package com.shawn.mall.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.*;
import com.shawn.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * role controller
 */
@Controller
@Api(tags = "UmsRoleController", description = "role")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole role) {
        int count = roleService.create(role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("modify")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("multiple delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = roleService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("get role permission ")
    @RequestMapping(value = "/permission/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long roleId) {
        List<UmsPermission> permissionList = roleService.getPermissionList(roleId);
        return CommonResult.success(permissionList);
    }

    @ApiOperation("modify role permission ")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestParam Long roleId,
                                         @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = roleService.updatePermission(roleId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("get all roles")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }

    @ApiOperation("paging get list base on keyword, role name")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> roleList = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("modify role status")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("get role related menu")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("get role related resource")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("assign menu to role")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("assign resource to role")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }

}
