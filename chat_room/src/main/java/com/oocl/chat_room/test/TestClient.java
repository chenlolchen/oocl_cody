package com.oocl.chat_room.test;

import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.manager.impl.ChatRoomManagerImpl;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.ChatSocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2017/7/16.
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        // 启动后需要开启client start()才能测试
        try {
            ChatRoomManager chatRoomManager = new ChatRoomManagerImpl();
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(8888);
            System.out.println("server is running");
            while (true) {
                Socket socket = serverSocket.accept();
                ChatSocket chatSocket = new ChatSocket(socket);
                chatRoomManager.register(chatSocket);
                new Thread(chatSocket).start();
                // 服务端往客户端发送消息
                chatSocket.send(new DataPackage("server", "client", DataPackage.MessageType.MESSAGE, "test data"));
                chatSocket.send(new DataPackage("server", "client", DataPackage.MessageType.MESSAGE, "test data2"));
                chatSocket.send(new DataPackage("server", "client", DataPackage.MessageType.MESSAGE, "test data3"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
