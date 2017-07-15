package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.action.Action;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.ui.ChatFrame;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ClientAction implements Action {
    private ChatFrame chatFrame;

    public ClientAction(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
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
