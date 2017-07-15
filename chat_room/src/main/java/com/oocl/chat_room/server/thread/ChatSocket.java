package com.oocl.chat_room.server.thread;

import com.oocl.chat_room.action.impl.ServerAction;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ChatSocket implements Runnable {
    private User user;
    private Socket socket;
    private boolean flag;
    private ServerAction serverAction;
    private DataPackageAnalyser dataPackageAnalyser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ChatSocket(Socket socket) {
        this.socket = socket;
        this.serverAction = new ServerAction(this);
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    public void send(DataPackage send) {
        dataPackageAnalyser.sendPackage(send);
    }

    public void run() {
        flag = true;
        while (flag) {
            DataPackage dataPackage = dataPackageAnalyser.readPackage();
            serverAction.handleDatapackage(dataPackage);
        }
    }
}