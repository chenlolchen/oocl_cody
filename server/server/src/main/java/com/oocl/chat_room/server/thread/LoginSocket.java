package com.oocl.chat_room.server.thread;

import com.oocl.chat_room.action.chat_frame.impl.LoginAction;
import com.oocl.chat_room.protocol.DataPackage;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class LoginSocket implements Runnable {
    private LoginAction loginAction;
    private boolean flag;

    public LoginSocket(Socket socket) {
        this.loginAction = new LoginAction(socket, this);
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void send(DataPackage send) {
        System.out.println("send..");
        loginAction.sendDataPackage(send);
    }

    @Override
    public void run() {
        flag = true;
        while (flag) {
            DataPackage dataPackage = loginAction.receiveDataPackage();
            loginAction.handleDataPackage(dataPackage);
        }
    }
}
