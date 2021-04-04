package com.hzsun.demo;

import com.alibaba.fastjson.JSON;
import com.hzsun.demo.EasyExcel.ExcelUtil;
import com.hzsun.demo.EasyExcel.OrderExcelBO;
import com.hzsun.demo.async.AsyncComponent;
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

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@EnableAsync
@Configuration
public class TestDemoApplication {

	@RequestMapping(value = "/print", produces = "application/json; charset=utf-8")
	//会乱码
	public void print(PrintWriter pw, HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		Map map = new HashMap();
		map.put("地址", request.getRequestURI());
		pw.write(JSON.toJSONString(map));
		pw.flush();
		pw.close();
	}
	@RequestMapping(value = "/print/", produces = "application/json; charset=utf-8")
	//会乱码
	public void print_(PrintWriter pw, HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		Map map = new HashMap();
		map.put("地址", request.getRequestURI());
		pw.write(JSON.toJSONString(map));
		pw.flush();
		pw.close();
	}

	@RequestMapping(value = "/print2/**")
	public Map print2(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		map.put("地址", request.getRequestURI());
		return map;
	}

	@RequestMapping(value = "/print3", produces = "application/json; charset=utf-8")
	public String print3() throws Exception {
		Map map = new HashMap();
		map.put("name", "帅哥");
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/print4", produces = "application/json; charset=utf-8")
	//会乱码
	public void print4(PrintWriter pw) throws Exception {
		pw.write("帅哥");
		pw.flush();
		pw.close();
	}

	//http://127.0.0.1:8086/urltest?a=1  ->  {"URI":"/urltest","URL":"http://127.0.0.1:8086/urltest"}
	@RequestMapping(value = "/urltest", produces = "application/json; charset=utf-8")
	public String urltest(HttpServletRequest request) throws Exception {
		Map map = new HashMap();
		map.put("URI", request.getRequestURI());
		map.put("URL", request.getRequestURL().toString());
		return JSON.toJSONString(map);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestDemoApplication.class, args);
	}
}
