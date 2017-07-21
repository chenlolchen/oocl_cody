package com.oocl.chat_room.start;

import java.io.IOException;

import com.oocl.chat_room.server.ServerWeb;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class ServerWebStart {
    public static void main(String[] args) throws IOException {
        ServerWeb serverWeb = new ServerWeb();
        serverWeb.start();
    }
}
