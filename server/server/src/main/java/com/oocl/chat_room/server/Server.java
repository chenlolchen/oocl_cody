package com.oocl.chat_room.server;

import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.manager.impl.ChatRoomManagerImpl;
import com.oocl.chat_room.server.thread.ChatSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class Server implements Runnable {
    private ServerSocket serverSocket;
    private ChatRoomManager chatRoomManager;
    private boolean flag;

    public Server() {
        chatRoomManager = new ChatRoomManagerImpl();
    }

    public void run() {
        flag = true;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("server is running");
            while (flag) {
                Socket socket = serverSocket.accept();
                ChatSocket chatSocket = new ChatSocket(socket);
                chatRoomManager.register(chatSocket);
                new Thread(chatSocket).start();
            }

        } catch (Exception e) {
            System.out.println("server is stop..");
        }
    }

    public void stop() {
        chatRoomManager.removeAll();
        this.flag = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
