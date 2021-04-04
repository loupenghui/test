package com.hzsun.test.restfulwebservice.controller;

import com.hzsun.test.restfulwebservice.bean.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/12 0012
 */
@RestController
public class RestfulController {
	private static final String template= "Hello,%S!";
	private final AtomicLong counter = new AtomicLong();

	@Value("${logging.path2}")
	private String path;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name){
		return new Greeting(counter.incrementAndGet(),String.format(template,name)+path);
	}
}
