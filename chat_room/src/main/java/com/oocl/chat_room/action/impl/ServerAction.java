package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.action.Action;
import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.manager.impl.ChatRoomManagerImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.ChatSocket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ServerAction implements Action {
    private ChatSocket chatSocket;
    private ChatRoomManager chatRoomManager;

    public ServerAction(ChatSocket chatSocket) {
        this.chatSocket = chatSocket;
        this.chatRoomManager = new ChatRoomManagerImpl();
    }

    @Override
    public void handleDatapackage(DataPackage dataPackage) {
        if (dataPackage.getMessageType() == DataPackage.MessageType.LOGIN) {
            chatSocket.setUser(new User(dataPackage.getFromName()));
            chatRoomManager.showList();
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.MESSAGE) {
            if (dataPackage.getToName().equals("ALL") || dataPackage.getToName().equals("")) {
                chatRoomManager.sendAll(dataPackage);
            } else if(!dataPackage.getToName().equals(chatSocket.getUser().getName())){
                chatRoomManager.sendToSelected(dataPackage);
            }
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.LOGOUT) {
            chatRoomManager.removeItem(dataPackage);
            chatSocket.setFlag(false);
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.SHAKE) {
            if (dataPackage.getToName().equals("ALL") || dataPackage.getToName().equals("")) {
                chatRoomManager.shakeAll(dataPackage);
            } else if(!dataPackage.getToName().equals(chatSocket.getUser().getName())) {
                chatRoomManager.shakeToSelected(dataPackage);
            }
        }
    }
}
