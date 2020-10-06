package com.shawn.mall.search.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.search.domain.EsProduct;
import com.shawn.mall.search.domain.EsProductRelatedInfo;
import com.shawn.mall.search.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Search product controller
 */
@Controller
@Api(tags = "EsProductController",description="search product manage")
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "Import all database product to ES")
    @RequestMapping(value = "/importAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "Delete product base on id")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "Delete multiple products")
    @RequestMapping(value = "/delete/batch",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "Create product base on id")
    @RequestMapping(value = "/create/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct =esProductService.create(id);
        if(esProduct!=null){
            return CommonResult.success(esProduct);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "simple search")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "Search, Filter, Sort")
    @ApiImplicitParam(name = "sort", value = "sort:0->related；1->new；2->sale；3->low to high；4->high to low",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) Long brandId,
                                                      @RequestParam(required = false) Long productCategoryId,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                      @RequestParam(required = false, defaultValue = "0") Integer sort) {
        Page<EsProduct> esProductPage = esProductService.search(keyword,brandId,productCategoryId,pageNum,pageSize,sort);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "Recommend base on product id")
    @RequestMapping(value = "/recommend/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> recommend(@PathVariable Long id,
                                                         @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.recommend(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "Search releated brand, category and filter attr")
    @RequestMapping(value = "/search/relate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<EsProductRelatedInfo> searchRelatedInfo(@RequestParam(required = false) String keyword) {
        EsProductRelatedInfo productRelatedInfo = esProductService.searchRelatedInfo(keyword);
        return CommonResult.success(productRelatedInfo);
    }
}
