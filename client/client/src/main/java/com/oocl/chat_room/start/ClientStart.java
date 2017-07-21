package com.oocl.chat_room.start;

import com.oocl.chat_room.ui.LoginFrame;

/**
 * Created by chen on 2017/7/15.
 */
public class ClientStart {
    public static void main(String[] args) {
        new Thread(new LoginFrame()).start();
    }
}