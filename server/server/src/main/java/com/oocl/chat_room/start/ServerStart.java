package com.oocl.chat_room.start;

import com.oocl.chat_room.server.Server;

/**
 * Created by chen on 2017/7/15.
 */
public class ServerStart {
    public static void main(String[] args) {
        Server server = new Server();
        new Thread(server).start();
//        server.start();
    }
}