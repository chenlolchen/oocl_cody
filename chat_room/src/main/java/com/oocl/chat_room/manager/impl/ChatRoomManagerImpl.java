package com.oocl.chat_room.manager.impl;

import com.oocl.chat_room.manager.ChatRoomManager;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.ChatSocket;

import java.util.Vector;

/**
 * Created by chen on 2017/7/15.
 */
public class ChatRoomManagerImpl implements ChatRoomManager {
    private static Vector<ChatSocket> chatroom = new Vector<ChatSocket>();

    @Override
    public void register(ChatSocket chatSocket) {
        chatroom.add(chatSocket);
    }

    @Override
    public void sendToSelected(DataPackage dataPackage) {
        for (ChatSocket chat : chatroom) {
            if (chat.getUser().getName().equals(dataPackage.getToName())) {
                chat.send(dataPackage);
            }
        }
    }

    @Override
    public void sendAll(DataPackage dataPackage) {
        for (ChatSocket chat : chatroom) {
            if (!chat.getUser().getName().equals(dataPackage.getFromName())) {
                chat.send(dataPackage);
            }
        }
    }

    @Override
    public void showList() {
        StringBuilder sb = new StringBuilder();
        for (ChatSocket chat : chatroom) {
            sb.append(chat.getUser().getName() + "\\");
        }

        for (ChatSocket chat : chatroom){
            DataPackage send = new DataPackage(chat.getUser().getName(),"ALL", DataPackage.MessageType.LIST, sb.toString());
            chat.send(send);
        }

    }

    @Override
    public void removeItem(DataPackage dataPackage) {
        DataPackage dp;
//        for (Iterator<ChatSocket> iterator = chatroom.iterator(); iterator.hasNext();) {
//            ChatSocket user = iterator.next();
//            if (user.getUser().getName().equals(chatSocket.getUser().getName())) {
//                p = new DataPackage(chatSocket.getUser().getName(), "ALL", MessageType.CLOSE, "CLOSE");
//                iterator.remove();
//                user.send(p);
//            }else {
//                p = new DataPackage(chatSocket.getUser().getName(), "ALL", MessageType.LIST, "LIST");
//                user.send(p);
//            }
//        }
        ChatSocket temp = null;
        for (ChatSocket chat : chatroom) {
            if (chat.getUser().getName().equals(dataPackage.getFromName())) {
                dp = new DataPackage(dataPackage.getFromName(), "ALL", DataPackage.MessageType.LOGOUT, "LOGOUT");
                temp = chat;
                chat.send(dp);
            }
        }
        chatroom.remove(temp);

        for (ChatSocket chat : chatroom) {
            dp = new DataPackage(dataPackage.getFromName(), "ALL", DataPackage.MessageType.LOGOUT, "LOGOUT");
            chat.send(dp);
        }
    }

    @Override
    public void shakeAll(DataPackage dataPackage) {
        for (ChatSocket chat : chatroom) {
            if (!chat.getUser().getName().equals(dataPackage.getFromName())) {
                chat.send(dataPackage);
            }
        }
    }

    @Override
    public void shakeToSelected(DataPackage dataPackage) {
        for (ChatSocket chat : chatroom) {
            if (chat.getUser().getName().equals(dataPackage.getToName())) {
                chat.send(dataPackage);
            }
        }
    }
}