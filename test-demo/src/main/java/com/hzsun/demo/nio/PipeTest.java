package com.hzsun.demo.nio;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/6 0006
 */
public class PipeTest {
	public static void main(String[] args) throws Exception{
		Pipe pipe = Pipe.open();
		Pipe.SinkChannel sinkChannel = pipe.sink();
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		buf.flip();
		while(buf.hasRemaining()) {
			sinkChannel.write(buf);
		}

		//从管道读数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		buf.clear();
		int bytesRead = sourceChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = sourceChannel.read(buf);
		}



	}
}
