package com.oocl.chat_room.action;

import com.oocl.chat_room.protocol.DataPackage;

/**
 * Created by chen on 2017/7/15.
 */
public interface Action {
    void handleDatapackage(DataPackage dataPackage);

    void sendDataPackage(DataPackage dataPackage);

    DataPackage receiveDataPackage();
}
