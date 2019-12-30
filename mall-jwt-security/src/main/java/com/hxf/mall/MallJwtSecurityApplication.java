package com.hxf.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hxf.mall.mbg.mapper","com.hxf.mall.dao"})
public class MallJwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallJwtSecurityApplication.class, args);
	}

}
