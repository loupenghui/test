package com.hzsun.demo.async;

import com.alibaba.fastjson.JSON;
import com.hzsun.demo.EasyExcel.ExcelUtil;
import com.hzsun.demo.EasyExcel.OrderExcelBO;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class AsyncController {
	@Autowired
	private AsyncComponent asyncComponent;
	@GetMapping("async1")
	public String async1(HttpServletResponse response) throws Exception {
		asyncComponent.asyncMethodWithVoidReturnType();
		System.out.println("async1：" + Thread.currentThread().getName());
		return "success";
	}
	@GetMapping("async2")
	public String async2(HttpServletResponse response) throws Exception {
		asyncComponent.asyncMethodWithReturnType();
		System.out.println("async2：" + Thread.currentThread().getName());
		return "success";
	}

	@Autowired
	private ApplicationContext applicationContext;
	@GetMapping("async3")
	public String async3(HttpServletResponse response) throws Exception {
		boolean isAop = AopUtils.isAopProxy(AsyncController.class);//是否是代理对象；
		boolean isCglib = AopUtils.isCglibProxy(AsyncController.class);  //是否是CGLIB方式的代理对象；
		boolean isJdk = AopUtils.isJdkDynamicProxy(AsyncController.class);  //是否是JDK动态代理方式的代理对象；
		//以下才是重点!!!
		AsyncController emailService = (AsyncController)applicationContext.getBean(AsyncController.class);
		AsyncController proxy = (AsyncController) AopContext.currentProxy();
		System.out.println(emailService == proxy ? true : false);
		proxy.async3MethodTest();
		System.out.println("end!!!");
		System.out.println("async3：" + Thread.currentThread().getName());
		return "success";
	}
	@GetMapping("async4")
	public String async4(HttpServletResponse response) throws Exception {
		AsyncController emailService = (AsyncController)applicationContext.getBean(AsyncController.class);
		emailService.async4MethodTest();
		System.out.println("async4：" + Thread.currentThread().getName());
		return "success";
	}
	@Async
	public void async3MethodTest(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("async3-async3MethodTest：" + Thread.currentThread().getName());
	}
	@Async
	public void async4MethodTest(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("async4-async3MethodTest：" + Thread.currentThread().getName());
	}
}

