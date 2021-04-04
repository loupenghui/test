package com.hzsun.demo.testdemo;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/5/8 0008
 */
public class StaticTest {
	static {//静态块
		System.out.println("static block ");
	}
}
 class Main {

	Class[] classArray = {
			StaticTest.class//这样引用该类，必然需要将该类加载到虚拟机中，（反射机制）
	};
	public static void main(String[] args) throws Exception{
		System.out.println(StaticTest.class.getPackage().getName());
		Class.forName("com.hzsun.demo.testdemo.MyClass1",false,Main.class.getClassLoader());
		System.out.println("hello word");
	}
}