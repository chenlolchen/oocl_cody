package com.oocl.chat_room.server;

import com.oocl.chat_room.server.thread.RegisterSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class RegisterServer implements Runnable {
    private ServerSocket serverSocket;
    private boolean flag;

    public RegisterServer() {

    }

    public void run() {
        flag = true;
        try {
            serverSocket = new ServerSocket(8001);
            System.out.println("register server is running");
            while (flag) {
                Socket socket = serverSocket.accept();
                RegisterSocket registerSocket = new RegisterSocket(socket);
                new Thread(registerSocket).start();
            }
        } catch (Exception e) {
            System.out.println("register server is stop..");
        }

    }

    public void stop() {
        this.flag = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
