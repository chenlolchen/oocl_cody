package com.oocl.scp_ssh.tcp;

import com.oocl.scp_ssh.controller.Controller;
import com.oocl.scp_ssh.controller.impl.ControllerImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/11/2017.
 */
public class TcpServer {
    public static void main(String[] args) throws Exception {
        final String PATH = "ftp/";
        ServerSocket server = new ServerSocket(8888);
        System.out.println("server is running");
        while (true){
            Socket socket = server.accept();
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            Controller controller = new ControllerImpl(in, out);
            out.write("please input your command:\n".getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String cmd;
            boolean flag = true;
            while (flag){
                cmd = reader.readLine();
                if(cmd != null){
                    StringBuilder result = controller.commandProcess(cmd);
                    out.write(result.toString().getBytes());
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
