package com.oocl.chat_room.server.thread;

import com.oocl.chat_room.action.chat_frame.impl.ChatAction;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ChatSocket implements Runnable {
    private ChatAction chatAction;
    private User user;
    private boolean flag;

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
        this.chatAction = new ChatAction(socket, this);
    }

    public void send(DataPackage send) {
        chatAction.sendDataPackage(send);
    }

    public void run() {
        flag = true;
        while (flag) {
            DataPackage dataPackage = chatAction.receiveDataPackage();
            chatAction.handleDataPackage(dataPackage);
        }
    }
}