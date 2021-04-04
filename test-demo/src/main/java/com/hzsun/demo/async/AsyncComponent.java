package com.hzsun.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/27 0027
 */
@Component
public class AsyncComponent {
	@Async  //标注使用
	public void asyncMethodWithVoidReturnType() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//
		}
		System.out.println("async1-asyncMethodWithVoidReturnType: " + Thread.currentThread().getName());
	}

	@Async
	public Future<String> asyncMethodWithReturnType() {
		try {
			Thread.sleep(5000);
			System.out.println("async2-asyncMethodWithVoidReturnType: " + Thread.currentThread().getName());
			return new AsyncResult<String>("hello world !!!!");
		} catch (InterruptedException e) {
			//
		}

		return null;
	}
}
