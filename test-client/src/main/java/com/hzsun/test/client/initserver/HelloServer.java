package com.hzsun.test.client.initserver;

import com.hzsun.demotest.hessian.api.IHelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
@Component
public class HelloServer {
	@Bean
	public HessianProxyFactoryBean redisServiceClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:9094/Hessian/helloService");
		factory.setServiceInterface(IHelloService.class);
		factory.setOverloadEnabled(true); // 调整通信中产生的编码异常
		return factory;
	}
}
