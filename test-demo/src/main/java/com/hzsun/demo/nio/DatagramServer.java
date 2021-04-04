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
public class DatagramServer {
	public static void main(String[] args) {
		DatagramChannel channel = null;
		try {
			channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(1234));
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			SocketAddress socketAddress = channel.receive(buf);
			buf.flip();
			while (buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
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
