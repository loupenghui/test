package com.hzsun.test.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
* @Description:
 * @Author: dingjl
* @Date: 2018年4月13日
**/
@Configuration
public class SpringWebConfiguration {


    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(1);
        return viewResolver;

    }


}

