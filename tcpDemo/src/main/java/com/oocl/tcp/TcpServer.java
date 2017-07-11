package com.oocl.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/11/2017.
 */
public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        //等待连接
        Socket socket = server.accept();
        //telnet 127.0.0.1 8888 can close the connection
        System.out.println("continue ....");
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        out.write("who are you?".getBytes());


//        char name = (char)in.read();
//        System.out.println(name);

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String name = reader.readLine();
        System.out.println(name);
        out.write(("Hello :" + name).getBytes());

        out.close();
        in.close();
        socket.close();
        server.close();
    }
}
