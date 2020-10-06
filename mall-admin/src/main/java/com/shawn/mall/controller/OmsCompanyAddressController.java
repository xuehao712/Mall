package com.shawn.mall.controller;

import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.OmsCompanyAddress;
import com.shawn.mall.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Company address Controller
 */
@Controller
@Api(tags = "OmsCompanyAddressController", description = "Company address")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("Get all address")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list() {
        List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }
}
