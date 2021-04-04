package com.hzsun.test.log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/27 0027
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Log4j2Application {

	public static void main(String[] args) {
		SpringApplication.run(Log4j2Application.class, args);
	}
}
