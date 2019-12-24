package com.hxf.mall.controller;

import com.hxf.mall.common.api.CommonResult;
import com.hxf.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Suncm
 * @ClassName UmsMemberController
 * @Description 会员登录管理
 * @Date 2019/12/24 10:21
 * @Version 1.0
 */
@Controller
@RequestMapping("/sso")
@Api(tags = "umsMemberController",description = "会员登录注册管理")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @ResponseBody
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码和手机号是否匹配")
    @ResponseBody
    @RequestMapping(value = "verifyAuthCode",method = RequestMethod.POST)
    public CommonResult verifyAuthCode(@RequestParam String telephone,@RequestParam String AuthCode ){
        return umsMemberService.verifyAuthCode(telephone, AuthCode);
    }


}
