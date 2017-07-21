package com.oocl.chat_room.server.thread;

import com.oocl.chat_room.action.chat_frame.impl.RegisterAction;
import com.oocl.chat_room.protocol.DataPackage;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class RegisterSocket implements Runnable{
    private RegisterAction registerAction;
    private boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public RegisterSocket(Socket socket) {
        this.registerAction = new RegisterAction(socket, this);
    }

    public void send(DataPackage send) {
        registerAction.sendDataPackage(send);
    }

    @Override
    public void run() {
        flag = true;
        while (flag) {
            DataPackage dataPackage = registerAction.receiveDataPackage();
            registerAction.handleDataPackage(dataPackage);
        }
    }
}
