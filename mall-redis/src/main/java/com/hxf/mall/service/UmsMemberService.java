package com.hxf.mall.service;

import com.hxf.mall.common.api.CommonResult;

/**
 * @author Suncm
 * @ClassName UmsMemberService
 * @Description 添加根据电话号码获取验证码的接口和校验验证码的接口
 * @Date 2019/12/24 10:15
 * @Version 1.0
 */
public interface UmsMemberService {
    /*
     *生成验证码
     *
     **/
    CommonResult generateAuthCode(String telephone);

    /*
     *判断验证码和手机号码是否匹配
     **/
    CommonResult verifyAuthCode(String telephone,String authCode);
}
