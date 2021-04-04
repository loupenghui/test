package com.hzsun.demo.testdemo;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/12/13 0013
 */
public class Person {
	private String name;
	private Integer age;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}

class PersonFactory{
	public static Person newPrototypeInstance(){
		Address address = new Address();
		address.setType("Home");
		address.setValue("北京");

		Person p1 = new Person();
		p1.setAddress(address);
		p1.setAge(31);
		p1.setName("Peter");
		return p1;
	}
}