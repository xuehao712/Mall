package com.shawn.mall.portal.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.PmsBrand;
import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.portal.service.PortalBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Home page brand Controller
 */
@Controller
@Api(tags = "PortalBrandController", description = "Front end brand")
@RequestMapping("/brand")
public class PortalBrandController {

    @Autowired
    private PortalBrandService homeBrandService;

    @ApiOperation("Paging get recommend brand")
    @RequestMapping(value = "/recommendList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> recommendList(@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsBrand> brandList = homeBrandService.recommendList(pageNum, pageSize);
        return CommonResult.success(brandList);
    }

    @ApiOperation("Get brand detail")
    @RequestMapping(value = "/detail/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> detail(@PathVariable Long brandId) {
        PmsBrand brand = homeBrandService.detail(brandId);
        return CommonResult.success(brand);
    }

    @ApiOperation("Paging get brand related products")
    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> productList(@RequestParam Long brandId,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        CommonPage<PmsProduct> result = homeBrandService.productList(brandId,pageNum, pageSize);
        return CommonResult.success(result);
    }
}
