package com.hzsun.test.websocket.component;

import com.alibaba.fastjson.JSONObject;
import com.hzsun.test.websocket.controller.WebSocket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/26 0026
 */
@Component
public class SocketServer implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(5000);
					WebSocket ws = new WebSocket();

					JSONObject jo = new JSONObject();
					int index = 0;
					//随机全发
					if ((index = new Random().nextInt(3)) == 1||WebSocket.getClients().size()==0) {
						jo.put("message", "通知全部");
						jo.put("To", "All");
					} else {
						jo.put("message", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						index = new Random().nextInt(WebSocket.getClients().size());
						Iterator<String> iterator = WebSocket.getClients().keySet().iterator();
						while (iterator.hasNext()){
							String sessionId = iterator.next();
							if(index--==0){
								jo.put("To", sessionId);
								break;
							}
						}

					}
					System.out.println(jo.toString());
					ws.onMessage(jo.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

	}
}
