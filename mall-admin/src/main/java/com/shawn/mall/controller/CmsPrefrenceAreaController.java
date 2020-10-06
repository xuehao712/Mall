package com.shawn.mall.controller;

import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.CmsPreferenceArea;
import com.shawn.mall.service.CmsPreferenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * preference product Controller
 */
@Controller
@Api(tags = "CmsPreferenceAreaController", description = "preference product")
@RequestMapping("/preferenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPreferenceAreaService prefrenceAreaService;

    @ApiOperation("Get all products")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPreferenceArea>> listAll() {
        List<CmsPreferenceArea> preferenceAreaList = prefrenceAreaService.listAll();
        return CommonResult.success(preferenceAreaList);
    }
}
