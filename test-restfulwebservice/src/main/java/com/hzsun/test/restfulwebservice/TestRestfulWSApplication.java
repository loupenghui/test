package com.hzsun.test.restfulwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/27 0027
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TestRestfulWSApplication {
	static Logger logger = LoggerFactory.getLogger(TestRestfulWSApplication.class);

	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {
		logger.info(Arrays.toString(args));
		SpringApplication.run(TestRestfulWSApplication.class, args);
	}
}
