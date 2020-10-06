package com.shawn.mall.demo.controller;

import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.demo.dto.PmsBrandDto;
import com.shawn.mall.demo.service.DemoService;
import com.shawn.mall.model.PmsBrand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Brand management example controller
 */
@Api(tags = "DemoController", description = "Brand management template api")
@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @ApiOperation(value = "Get all brand list")
    @RequestMapping(value = "/brand/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    @ApiOperation(value = "add brand")
    @RequestMapping(value = "/brand/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@Validated @RequestBody PmsBrandDto pmsBrand, BindingResult result) {
        if(result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        CommonResult commonResult;
        int count  = demoService.createBrand(pmsBrand);
        if(count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        }else {
            commonResult = CommonResult.failed("Operating fail");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation(value = "Update brand")
    @RequestMapping(value = "/brand/update/{id",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id,@Validated @RequestBody PmsBrandDto pmsBrandDto,BindingResult result){
        if(result.hasErrors()){
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        CommonResult commonResult;
        int count = demoService.updateBrand(id,pmsBrandDto);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}",pmsBrandDto);
        }else{
            commonResult = CommonResult.failed("Operation failed");
            LOGGER.debug("updateBrand failed:{}",pmsBrandDto);
        }
        return  commonResult;
    }

    @ApiOperation(value ="Delete brand")
    @RequestMapping(value = "/brand/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = demoService.deleteBrand(id);
        if(count == 1){
            LOGGER.debug("deleteBrand success : id={}",id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed : id={}",id);
            return CommonResult.failed("Operation failed");
        }
    }

    @ApiOperation(value = "Search brand info base on id")
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(demoService.getBrand(id));
    }
}
