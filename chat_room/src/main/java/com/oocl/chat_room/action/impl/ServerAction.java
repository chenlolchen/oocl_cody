package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.action.Action;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.manager.impl.ChatRoomManagerImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.ChatSocket;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ServerAction implements Action {
    private ChatSocket chatSocket;
    private ChatRoomManager chatRoomManager;
    private DataPackageAnalyser dataPackageAnalyser;

    public ServerAction(Socket socket, ChatSocket chatSocket) {
        this.chatSocket = chatSocket;
        this.chatRoomManager = new ChatRoomManagerImpl();
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    @Override
    public void handleDataPackage(DataPackage dataPackage) {
        System.out.println(dataPackage);
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

    @Override
    public void sendDataPackage(DataPackage dataPackage){
        dataPackageAnalyser.sendPackage(dataPackage);
    }

    @Override
    public DataPackage receiveDataPackage(){
        return dataPackageAnalyser.readPackage();
    }

}
