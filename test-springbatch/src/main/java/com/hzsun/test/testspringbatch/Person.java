package com.hzsun.test.testspringbatch;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/9 0009
 */
public class Person {
	private String firstName;
	private String lastName;

	public Person() {
		// default constructor
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
