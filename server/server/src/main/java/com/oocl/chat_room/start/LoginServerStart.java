package com.oocl.chat_room.start;

import com.oocl.chat_room.server.LoginServer;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class LoginServerStart {
    public static void main(String[] args) {
        LoginServer loginServer = new LoginServer();
        new Thread(loginServer).start();
    }
}
