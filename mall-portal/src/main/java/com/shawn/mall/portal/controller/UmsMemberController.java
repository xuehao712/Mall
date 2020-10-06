package com.shawn.mall.portal.controller;

import com.shawn.mall.common.api.CommonResult;
import com.shawn.mall.model.UmsMember;
import com.shawn.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Member login register controller
 */
@Controller
@Api(tags = "UmsMemberController", description = "Member register login")
@RequestMapping("/sso")
public class UmsMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("Member register")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 @RequestParam String authCode) {
        memberService.register(username, password, email, authCode);
        return CommonResult.success(null,"Register success");
    }

    @ApiOperation("Member login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("Username or password incorrect");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("Get member info")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @ApiOperation("Get auth code")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String email) {
        String authCode = memberService.generateAuthCode(email);
        return CommonResult.success(authCode,"Get auth code success");
    }

    @ApiOperation("Modify password")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        memberService.updatePassword(email,password,authCode);
        return CommonResult.success(null,"Password modify success");
    }


    @ApiOperation(value = "refresh token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token is expired！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
