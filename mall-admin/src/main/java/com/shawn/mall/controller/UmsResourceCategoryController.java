package com.shawn.mall.controller;

import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.UmsResourceCategory;
import com.shawn.mall.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * resource category Controller
 */
@Controller
@Api(tags = "UmsResourceCategoryController", description = "resource category ")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("get all list")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory) {
        int count = resourceCategoryService.create(umsResourceCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("modify ")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory) {
        int count = resourceCategoryService.update(id, umsResourceCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = resourceCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
