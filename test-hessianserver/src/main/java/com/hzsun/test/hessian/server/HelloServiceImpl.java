package com.hzsun.test.hessian.server;

import com.hzsun.demotest.hessian.api.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
@Service
public class HelloServiceImpl implements IHelloService {
	@Override
	public String sayHello(String msg) {
		return "hello, " + msg;
	}
}
