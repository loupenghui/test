package com.hzsun.demo.testdemo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/12/13 0013
 */
public class Address implements Serializable {
	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}