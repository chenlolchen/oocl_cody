package com.oocl.chat_room.manager;

import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.ChatSocket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public interface ChatRoomManager {
    void register(ChatSocket userSocket);

    void showList();

    void sendAll(DataPackage dataPackage);

    void sendToSelected(DataPackage dataPackage);

    void removeItem(DataPackage dataPackage);

    void shakeAll(DataPackage dataPackage);

    void shakeToSelected(DataPackage dataPackage);
}
