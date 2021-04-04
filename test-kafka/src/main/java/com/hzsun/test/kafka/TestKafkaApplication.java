package com.hzsun.test.kafka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.hzsun.test.kafka.mapper")
@ComponentScan(basePackages = "com.hzsun.test.kafka")
@EnableAutoConfiguration
@EnableTransactionManagement
public class TestKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKafkaApplication.class, args);
	}
}
