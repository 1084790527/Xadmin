package com.yao.before;

import com.yao.common.util.IdWorker;
import com.yao.common.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeforeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeforeApplication.class, args);
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
