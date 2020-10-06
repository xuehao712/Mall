package com.shawn.mall.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.SmsCouponHistory;
import com.shawn.mall.service.SmsCouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * coupon history Controller
 */
@Controller
@Api(tags = "SmsCouponHistoryController", description = "coupon history")
@RequestMapping("/couponHistory")
public class SmsCouponHistoryController {
    @Autowired
    private SmsCouponHistoryService historyService;

    @ApiOperation("get coupon history base on differnet param")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsCouponHistory>> list(@RequestParam(value = "couponId", required = false) Long couponId,
                                                           @RequestParam(value = "useStatus", required = false) Integer useStatus,
                                                           @RequestParam(value = "orderSn", required = false) String orderSn,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsCouponHistory> historyList = historyService.list(couponId, useStatus, orderSn, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(historyList));
    }
}
