package com.oocl.handle_data;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.controller.impl.CustomerControllerImpl;
import com.oocl.handle_data.server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }
}
