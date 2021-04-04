package com.hzsun.test.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/25 0025
 */
@Component
@ServerEndpoint("/webSocket/{username}")
public class WebSocket {

	private static int onlineCount = 0;

	private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();

	private Session session;

	private String username;



	@OnOpen
	public void onOpen(@PathParam("username") String username, Session session) throws IOException {
		this.username = username;
		this.session = session;
		addOnlineCount();
		clients.put(username, this);
		System.out.println("已连接："+username);
	}



	@OnClose
	public void onClose() throws IOException {
		clients.remove(username);
		subOnlineCount();
	}

	@OnMessage
	public void onMessage(String message) throws IOException {

		JSONObject jsonTo = JSONObject.parseObject(message);
		String mes = (String) jsonTo.get("message");
		if(jsonTo.get("To")==null){
			System.out.println("来自客户端："+mes);
		}else if (!jsonTo.get("To").equals("All")){
			sendMessageTo(mes, jsonTo.get("To").toString());
		}else{
			sendMessageAll(mes);

		}

	}



	@OnError
	public void onError(Session session, Throwable error) {

		error.printStackTrace();

	}



	public void sendMessageTo(String message, String To) throws IOException {

		// session.getBasicRemote().sendText(message);

		//session.getAsyncRemote().sendText(message);

		for (WebSocket item : clients.values()) {

			if (item.username.equals(To) ){
				item.session.getAsyncRemote().sendText(message);
				break;
			}



		}

	}



	public void sendMessageAll(String message) throws IOException {

		for (WebSocket item : clients.values()) {

			item.session.getAsyncRemote().sendText(message);

		}

	}



	public static synchronized int getOnlineCount() {
		return onlineCount;
	}



	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}



	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}



	public static synchronized Map<String, WebSocket> getClients() {
		return clients;
	}

}
