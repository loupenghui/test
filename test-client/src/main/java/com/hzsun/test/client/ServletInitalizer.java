package com.hzsun.test.client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月13日  
**/
public class ServletInitalizer extends SpringBootServletInitializer {
    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(TestClientApplication.class);
    }
}
    