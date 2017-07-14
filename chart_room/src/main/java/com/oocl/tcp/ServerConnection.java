package com.oocl.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ServerConnection {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("server is running");
        while (true){
            Socket socket = server.accept();
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            Thread t = new Thread();
            out.write("please input your command:\n".getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String cmd;
            boolean flag = true;
            while (flag){
                cmd = reader.readLine();
                if(cmd != null){
                    out.write("a".getBytes());
                }else {
                    flag = false;
                }
            }
            out.close();
            in.close();
            socket.close();
        }
    }
}
