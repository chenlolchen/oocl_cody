package com.oocl.thread;

import com.oocl.pojo.User;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class UserThread implements Runnable {
    private User user;
    private Socket socket;

    public UserThread(User user, Socket socket){
        this.user = user;
        this.socket = socket;
    }

    public void run() {
        System.out.println("");
    }
}
