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
    public void handleDataPackage(DataPackage dataPackage) {
        if (dataPackage.getMessageType() == DataPackage.MessageType.MESSAGE) {
            chatFrame.getChatTa().append(dataPackage.getMessageData() + "\r\n");
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.LIST) {
            addModelToChatFrame(dataPackage.getMessageData());
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.LOGOUT) {
            if (dataPackage.getFromName().equals(chatFrame.getUser().getName())) {
                chatFrame.setFlag(false);
            } else {
                if(chatFrame.getFriendsJl().getSelectedValue().equals(dataPackage.getFromName())){
                    chatFrame.getFriendsJl().setSelectedIndex(0);
                }
                chatFrame.getModel().removeElement(dataPackage.getFromName());
            }
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.SHAKE) {
            chatFrame.shakeWindow();
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

    //format string like: "cody\\sky\\allen\\..."
    private void addModelToChatFrame(String message){
        String messagesData[] = message.split("\\\\");
        boolean flag = false;
        int size = chatFrame.getModel().getSize();
        for (String data : messagesData) {
            for (int j = 0; j < size; j++) {
                if (data.equals(chatFrame.getModel().get(j)) || chatFrame.getUser().getName().equals(data)) {
                    flag = true;
                }
            }
            if (!flag) {
                chatFrame.getModel().addElement(data);
            }
            flag = false;
        }
    }
}
