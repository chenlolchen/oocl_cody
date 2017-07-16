package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.action.Action;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.ui.ChatFrame;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ClientAction implements Action {
    private ChatFrame chatFrame;
    private DataPackageAnalyser dataPackageAnalyser;

    public ClientAction(Socket socket, ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    @Override
    public void handleDatapackage(DataPackage dataPackage) {
        if (dataPackage.getMessageType() == DataPackage.MessageType.MESSAGE) {
            chatFrame.getChatTa().append(dataPackage.getMessageData() + "\r\n");
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.LIST) {
            addModelToChatFrame(dataPackage.getMessageData());
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.LOGOUT) {
            if (dataPackage.getFromName().equals(chatFrame.getUser().getName())) {
                chatFrame.setFlag(false);
            } else {
                chatFrame.getModel().removeElement(dataPackage.getFromName());
            }
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.SHAKE) {
            chatFrame.shakeWindow();
        }
    }

    public void sendDataPackage(DataPackage dataPackage){
        dataPackageAnalyser.sendPackage(dataPackage);
    }

    public DataPackage receiveDataPackage(){
        DataPackage dataPackage = dataPackageAnalyser.readPackage();
        return dataPackage;
    }

    private void addModelToChatFrame(String message){
        String messagesData[] = message.split("\\\\");
        boolean flag = false;
        int size = chatFrame.getModel().getSize();
        for (int i = 0; i < messagesData.length; i++) {
            for (int j = 0; j < size; j++) {
                if (messagesData[i].equals(chatFrame.getModel().get(j))) {
                    flag = true;
                }
            }
            if (flag == false) {
                chatFrame.getModel().addElement(messagesData[i]);
            }
            flag = false;
        }
    }
}
