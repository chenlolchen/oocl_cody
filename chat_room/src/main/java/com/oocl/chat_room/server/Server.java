package com.oocl.chat_room.server;

import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.manager.impl.ChatRoomManagerImpl;
import com.oocl.chat_room.server.thread.ChatSocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class Server {
    private ServerSocket serverSocket;
    private ChatRoomManager chatRoomManager;

    public Server(){
        chatRoomManager = new ChatRoomManagerImpl();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("server is running");
            while (true) {
                Socket socket = serverSocket.accept();
                ChatSocket chatSocket = new ChatSocket(socket);
                chatRoomManager.register(chatSocket);
                new Thread(chatSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
