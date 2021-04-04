package com.hzsun.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/6 0006
 */
public class DatagramClient {
	public static void main(String[] args) {
		DatagramChannel channel = null;
		try {
			channel = DatagramChannel.open();
			String newData = "New String to write to file..." + System.currentTimeMillis();

			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();

			int bytesSent = channel.send(buf, new InetSocketAddress("127.0.0.1", 1234));
			System.out.println("发送"+bytesSent+"字节");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
