package com.hxf.mall.service;

import com.hxf.mall.mbg.model.UmsAdmin;
import com.hxf.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author Suncm
 * @ClassName UmsAdminService
 * @Description 后台管理员service
 * @Date 2019/12/25 14:34
 * @Version 1.0
 */
public interface UmsAdminService {
    /**
     *根据用户名获取管理员
     **/
    UmsAdmin getAdminByUsername(String username);

    /*
     *注册功能
     **/
    UmsAdmin register(UmsAdmin umsAdminParam);

    /*
     *登录功能
     * return 返回JWT的token
     **/
    String login(String username,String password);

    /*
     *获取所有用户权限
     **/
    List<UmsPermission> getPermissionList(Long adminId);
}

