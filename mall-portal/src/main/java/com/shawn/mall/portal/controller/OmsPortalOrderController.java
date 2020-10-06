package com.shawn.mall.portal.controller;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.portal.domain.ConfirmOrderResult;
import com.shawn.mall.portal.domain.OmsOrderDetail;
import com.shawn.mall.portal.domain.OrderParam;
import com.shawn.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Order Controller
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "Order")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("Generate confirm order base on cart info")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder(@RequestBody List<Long> cartIds) {
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder(cartIds);
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("Generate order base on cart info")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = portalOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "Order success");
    }

    @ApiOperation("Member payment success call back")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult paySuccess(@RequestParam Long orderId,@RequestParam Integer payType) {
        Integer count = portalOrderService.paySuccess(orderId,payType);
        return CommonResult.success(count, "Payment success");
    }

    @ApiOperation("Cancel timeout order")
    @RequestMapping(value = "/cancelTimeOutOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelTimeOutOrder() {
        portalOrderService.cancelTimeOutOrder();
        return CommonResult.success(null);
    }

    @ApiOperation("Cancel single order")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId) {
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }

    @ApiOperation("Get user order status base on order status")
    @ApiImplicitParam(name = "status", value = "Order status：-1->all；0->unpaid；1->unshipped；2->shipped；3->completed；4->closed",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderDetail>> list(@RequestParam Integer status,
                                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        CommonPage<OmsOrderDetail> orderPage = portalOrderService.list(status,pageNum,pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("Get order detail base on order id")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long orderId) {
        OmsOrderDetail orderDetail = portalOrderService.detail(orderId);
        return CommonResult.success(orderDetail);
    }

    @ApiOperation("Member cancel order")
    @RequestMapping(value = "/cancelUserOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelUserOrder(Long orderId) {
        portalOrderService.cancelOrder(orderId);
        return CommonResult.success(null);
    }

    @ApiOperation("Member confirm order")
    @RequestMapping(value = "/confirmReceiveOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult confirmReceiveOrder(Long orderId) {
        portalOrderService.confirmReceiveOrder(orderId);
        return CommonResult.success(null);
    }

    @ApiOperation("Member delete order")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteOrder(Long orderId) {
        portalOrderService.deleteOrder(orderId);
        return CommonResult.success(null);
    }
}
