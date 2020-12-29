package com.yao.sys;

import com.yao.common.util.IdWorker;
import com.yao.common.util.JwtUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan({"com.yao.sys.dao"})
public class SysApplication {

	private static Log log = LogFactory.getLog(SysApplication.class);

	public static void main(String[] args){
		SpringApplication.run(SysApplication.class, args);
		log.info("----------------------项目启动成功----------------------");
	}

	@Bean
	public IdWorker idWorker() {
		return new IdWorker();
	}

	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}

}
