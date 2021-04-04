package com.hzsun.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.MultipartConfigElement;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月13日  
**/
@Configuration
public class SpringWebConfiguration {

	@Value("${file.maxRequestUploadSize}")
	private String maxRequestUploadSize;
	@Value("${file.maxSingleUploadSize}")
	private String maxSingleUploadSize;
//    <!-- 静态资源映射 -->
//    <mvc:resources mapping="/**" location="/WEB-INF/"/>
//
    
    
//    <!-- 默认的视图解析器 在上边的解析错误时使用 (默认使用html)- -->
//    <bean id="defaultViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" p:order="1">
//        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
//        <property name="contentType" value="text/html"/>
//        <property name="prefix" value="/WEB-INF/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>
    
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
    
    /** 
     * 文件上传配置 
     * @return 
     */
    @Bean(name="fileUplodConfig")
    public MultipartConfigElement multipartConfigElement() { 
      MultipartConfigFactory factory = new MultipartConfigFactory(); 
      //文件最大 
      factory.setMaxFileSize(maxSingleUploadSize +"KB"); //KB,MB 
      /// 设置总上传数据总大小 
      factory.setMaxRequestSize(maxRequestUploadSize +"KB"); 
      return factory.createMultipartConfig(); 
    } 
    
    
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        // 线程池维护线程的最少数量
        pool.setCorePoolSize(5);
        // 线程池维护线程的最大数量
        pool.setMaxPoolSize(200);
        // 当调度器shutdown被调用时等待当前被调度的任务完成
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }


}
  
    