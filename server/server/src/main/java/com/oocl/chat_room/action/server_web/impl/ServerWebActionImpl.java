package com.oocl.chat_room.action.server_web.impl;

import com.oocl.chat_room.action.server_web.ServerWebAction;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.server.LoginServer;
import com.oocl.chat_room.server.RegisterServer;
import com.oocl.chat_room.server.Server;
import com.oocl.chat_room.service.register.RegisterService;
import com.oocl.chat_room.service.register.impl.RegisterServiceImpl;
import com.oocl.chat_room.util.DateUtil;
import com.oocl.chat_room.util.DomUtil;
import com.oocl.chat_room.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerWebActionImpl implements ServerWebAction{
	private RegisterService registerService;
	private Server server;
	private RegisterServer registerServer;
	private LoginServer loginServer;
	private Map<String,String> startTimeMap;
	private String time;
	
	public ServerWebActionImpl(){
		this.startTimeMap = new HashMap<String, String>();
		this.registerService = new RegisterServiceImpl();
		this.server = new Server();
		this.registerServer = new RegisterServer();
		this.loginServer = new LoginServer();
	}

	public void actionHandler(Socket socket) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStream out = socket.getOutputStream();
			String action = StringUtil.getStatus(reader);
			
			if(action == null || action.equals("")){
				 DomUtil.writeXml(out, null,null);
			}
			else if(action.equals("startAll")){
				startTimeMap.clear();
				time = DateUtil.formatDate(new Date().getTime());
				startTimeMap.put("server startTime", time);
				startTimeMap.put("register server startTime", time);
				startTimeMap.put("login server startTime", time);
				new Thread(server).start();	
				new Thread(loginServer).start();
	        	new Thread(registerServer).start();
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,userList,startTimeMap);
			}
			else if(action.equals("serverStart")){
				//startTimeMap.clear();
				time = DateUtil.formatDate(new Date().getTime());
				startTimeMap.put("server startTime", time); 
				new Thread(server).start();	
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,userList,startTimeMap);
			}
			else if(action.equals("registerServerStart")){
				//startTimeMap.clear();
				time = DateUtil.formatDate(new Date().getTime());
				startTimeMap.put("register server startTime", time); 
				new Thread(registerServer).start();	
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,userList,startTimeMap);
			}
			else if(action.equals("loginServerStart")){
				//startTimeMap.clear();
				time = DateUtil.formatDate(new Date().getTime());
				startTimeMap.put("login server startTime", time); 
				new Thread(loginServer).start();	
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,userList,startTimeMap);
			}
			else if(action.equals("refresh")){
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,userList,startTimeMap);
			}
			else if(action.equals("stopAll")){
				startTimeMap.clear();
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,null,startTimeMap);
				server.stop();
				loginServer.stop();
				registerServer.stop();
			}
			else if(action.equals("serverStop")){
				startTimeMap.remove("server startTime");
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,null,startTimeMap);
				server.stop();
			}
			else if(action.equals("registerStop")){
				startTimeMap.remove("register server startTime");
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,null,startTimeMap);
				registerServer.stop();
			}
			else if(action.equals("loginStop")){
				startTimeMap.remove("login server startTime");
				List<User> userList = registerService.getUserList();
				DomUtil.writeXml(out,null,startTimeMap);
				loginServer.stop();
			}
			
			out.close();
			reader.close();
			socket.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
