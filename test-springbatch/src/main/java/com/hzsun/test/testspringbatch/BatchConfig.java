package com.hzsun.test.testspringbatch;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/9 0009
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

	@Override
	public void setDataSource(DataSource dataSource) {
		// initialize will use a Map based JobRepository (instead of database)
	}
}
