package com.hzsun.test.restfulwebservice.bean;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/12 0012
 */
public class Greeting {
	private final long id;
	private final String greeting;

	public Greeting(long id, String greeting) {
		this.id = id;
		this.greeting = greeting;
	}

	public long getId() {
		return id;
	}

	public String getGreeting() {
		return greeting;
	}
}
