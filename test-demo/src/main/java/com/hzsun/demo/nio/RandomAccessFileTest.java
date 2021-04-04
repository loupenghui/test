package com.hzsun.demo.nio;

import java.io.RandomAccessFile;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/9 0009
 */
public class RandomAccessFileTest {
	public static void main(String[] args) throws Exception{
		RandomAccessFile file = new RandomAccessFile("E:\\桌面/test.txt", "rw");

//		file.seek(200);

		long pointer = file.getFilePointer();
		System.out.println("pointer："+pointer);

		file.close();
	}
}
