package com.oocl.chat_room.server;

import com.oocl.chat_room.server.thread.LoginSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class LoginServer implements Runnable{
    private ServerSocket serverSocket;
    private boolean flag;
    
    public LoginServer(){
    	  
    }

    public void run() {
       flag = true;
       try {
    	   serverSocket = new ServerSocket(8002);
            System.out.println("login server is running");
            while (flag) {
                Socket socket = serverSocket.accept();
                LoginSocket loginSocket = new LoginSocket(socket);
                new Thread(loginSocket).start();
            }
       } catch (Exception e) {
            System.out.println("login server is stop..");
        }
    }
    
    public void stop(){
    	this.flag = false;
    	try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}   
   	}
}
