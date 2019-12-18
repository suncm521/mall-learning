package com.hxf.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.hxf.mall.mbg.mapper"})
public class MallMybatisMbgSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallMybatisMbgSwaggerApplication.class, args);
	}

}
