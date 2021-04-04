package com.hzsun.test.hessian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
public class TestHessianServerApplication {
	static Logger logger = LoggerFactory.getLogger(TestHessianServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TestHessianServerApplication.class, args);
		logger.info("hessian server start");
	}
}
