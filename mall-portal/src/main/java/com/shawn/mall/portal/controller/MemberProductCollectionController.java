package com.shawn.mall.portal.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.portal.domain.MemberProductCollection;
import com.shawn.mall.portal.service.MemberCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "MemberCollectionController", description = "Member collection")
@RequestMapping("/member/productCollection")
public class MemberProductCollectionController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("Add product collection")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody MemberProductCollection productCollection) {
        int count = memberCollectionService.add(productCollection);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("Delete collection product")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(Long productId) {
        int count = memberCollectionService.delete(productId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("Display collection list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberProductCollection>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<MemberProductCollection> page = memberCollectionService.list(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("Display collection list")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MemberProductCollection> detail(@RequestParam Long productId) {
        MemberProductCollection memberProductCollection = memberCollectionService.detail(productId);
        return CommonResult.success(memberProductCollection);
    }

    @ApiOperation("Clear collection list")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult clear() {
        memberCollectionService.clear();
        return CommonResult.success(null);
    }
}
