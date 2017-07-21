package com.oocl.chat_room.start;

import com.oocl.chat_room.ui.RegisterFrame;

/**
 * Created by CHENCO7 on 7/21/2017.
 */
public class RegisterStart {
    public static void main(String[] args) {
        new Thread(new RegisterFrame()).start();
    }
}
