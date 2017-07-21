package com.oocl.chat_room.server;

import com.oocl.chat_room.action.server_web.impl.ServerWebActionImpl;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class ServerWeb {

    private ServerWebActionImpl serverAction;

    public ServerWeb() {
        serverAction = new ServerWebActionImpl();
    }

    public void start() {
        System.out.println("serverWeb start");
        try {
            ServerSocket serverSocket = new ServerSocket(9002);
            while (true) {
                Socket socket = serverSocket.accept();
                serverAction.actionHandler(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
