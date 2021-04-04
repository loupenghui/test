package com.hzsun.demo.nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/6 0006
 */
public class AsynchronousFileChannelTest{
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("E:/桌面/test.txt");
		if(!Files.exists(path)){
			Files.createFile(path);
		}
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int position = 0;
		/*fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				System.out.println("result = " + result);
				attachment.flip();
				byte[] data = new byte[attachment.limit()];
				attachment.get(data);
				System.out.println(new String(data));
				attachment.clear();
			}
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
			}
		});

		//写数据
		fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

		buffer = ByteBuffer.allocate(1024);
		position = 0;
		buffer.put("fileChannel.write".getBytes());
		buffer.flip();
		Future<Integer> operation = fileChannel.write(buffer, position);
		buffer.clear();
		while(!operation.isDone());
		System.out.println("Write done");
		fileChannel.close();*/


		fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
		buffer = ByteBuffer.allocate(1024);
		position = 0;
		buffer.put("CompletionHandler wri1555".getBytes());
		buffer.flip();
		fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				System.out.println("attachment: " + attachment.limit());
				attachment.flip();
				System.out.println("bytes written: " + result);
				byte[] bytes = new byte[attachment.limit()];
				attachment.get(bytes);
				System.out.println(new String(bytes));
			}
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				System.out.println("Write failed");
				exc.printStackTrace();
			}
		});
		//主线程（main）在异步线程执行之前退出了，处理过程是不会显示的控制台上的
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(5000);


	}
}
