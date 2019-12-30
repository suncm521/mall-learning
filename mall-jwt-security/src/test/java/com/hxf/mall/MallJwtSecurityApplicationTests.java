package com.hxf.mall;

import com.hxf.mall.common.utils.JwtTokenUtil;
import com.hxf.mall.mbg.model.UmsPermission;
import com.hxf.mall.service.UmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallJwtSecurityApplicationTests {
	@Autowired
	private UmsAdminService adminService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void umsAdminRoleRelationDaoTest() {
		long id = 3;
		List<UmsPermission> lists =  adminService.getPermissionList(id);
		for (UmsPermission umsPermission:lists){
			System.out.println(umsPermission);
		}
	}
}
