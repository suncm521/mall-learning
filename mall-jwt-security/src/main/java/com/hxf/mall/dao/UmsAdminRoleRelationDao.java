package com.hxf.mall.dao;

import com.hxf.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Suncm
 * @ClassName UmsAdminRoleRelationDao
 * @Description 后台用户与角色管理自定义Dao
 * @Date 2019/12/25 14:51
 * @Version 1.0
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
