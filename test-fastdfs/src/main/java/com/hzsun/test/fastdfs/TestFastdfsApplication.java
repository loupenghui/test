package com.hzsun.test.fastdfs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.hzsun.test.fastdfs.mapper")
@ComponentScan(basePackages = "com.hzsun.test.fastdfs")
@EnableAutoConfiguration
@EnableTransactionManagement
public class TestFastdfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFastdfsApplication.class, args);
	}
}
