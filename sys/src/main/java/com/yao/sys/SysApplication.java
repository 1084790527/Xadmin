package com.yao.sys;

import com.github.pagehelper.PageHelper;
import com.yao.common.util.IdWorker;
import com.yao.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
//@RestController
@MapperScan({"com.yao.sys.dao"})
@Slf4j
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);
		log.info("----------------------项目启动成功----------------------");
	}

//	@GetMapping("/")
//	public String index(){
//		return String.valueOf(idWorker().nextId());
//	}

	@Bean
	public IdWorker idWorker() {
		return new IdWorker();
	}

	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}

//	@Bean
//	public PageHelper pageHelper(){
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum","true");
//		properties.setProperty("rowBoundsWithCount","true");
//		properties.setProperty("reasonable","true");
//		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}
}
