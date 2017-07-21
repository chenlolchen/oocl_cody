package com.oocl.chat_room.start;

import com.oocl.chat_room.server.RegisterServer;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class RegisterServerStart {
    public static void main(String[] args) {
        RegisterServer registerServer = new RegisterServer();
        new Thread(registerServer).start();
//        registerServer.start();
    }
}
