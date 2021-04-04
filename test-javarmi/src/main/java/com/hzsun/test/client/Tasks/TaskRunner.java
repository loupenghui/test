package com.hzsun.test.client.Tasks;

import com.hzsun.demotest.rmi.api.IHello;
import com.hzsun.test.client.server.HelloImpl;
import com.hzsun.test.testrmiserver.server.CustomerSocketFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */
@Component
public class TaskRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		try {
			IHello hello = new HelloImpl();
			/* 生成stub和skeleton,并返回stub代理引用 */
			/* 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求
			 * 实际上，RMI Service本身也是一个RMI应用，我们也可以从远端获取Registry:
			 *     public interface Registry extends Remote;
			 *     public static Registry getRegistry(String host, int port) throws RemoteException;
			 */
			LocateRegistry.createRegistry(1099);
			//指定通信端口，防止被防火墙拦截
			RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
			/* 将stub代理绑定到Registry服务的URL上 */
			java.rmi.Naming.rebind("rmi://localhost:1099/hello", hello);
			System.out.println("Rmi Ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
