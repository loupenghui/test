package com.hzsun.test.client.controller;

import com.hzsun.demotest.hessian.api.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
@RestController
public class HessianController {
	@Autowired
	private IHelloService helloService;

	@GetMapping("/hessianClient")
	public String helloHessian() {
		return helloService.sayHello("jtzen9");
	}
}
