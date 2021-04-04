package com.hzusn.test.client;

import com.hzsun.demotest.rmi.api.IHello;
import org.junit.Test;

import java.rmi.Naming;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
public class TestClientApplicationTest {
	@Test
	public void rmiTest() throws Exception {
		IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
		/* 通过stub调用远程接口实现 */
		System.out.println(hello.sayHello("zhangxianxin"));
	}
}