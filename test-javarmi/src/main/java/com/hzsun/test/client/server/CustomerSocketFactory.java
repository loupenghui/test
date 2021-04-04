package com.hzsun.test.testrmiserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
public class CustomerSocketFactory extends RMISocketFactory {


	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		// TODO Auto-generated method stub
		if (port == 0) {
			port = 1098;
		}
		System.out.println("rmi notify port : " + port);
		return new ServerSocket(port);
	}

	//指定通信端口，防止被防火墙拦截
	@Override
	public Socket createSocket(String host, int port) throws IOException {
		// TODO Auto-generated method stub
		return new Socket(host, port);
	}

}
