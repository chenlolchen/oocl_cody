package com.oocl.handle_data.server;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.controller.impl.CustomerControllerImpl;
import com.oocl.handle_data.exception.FormatException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2017/7/11.
 */
public class Server {
    private CustomerController customerController;

    public Server() throws Exception {
        customerController = new CustomerControllerImpl();
        customerController.scanner("test_data.txt");
    }

    public void start() throws Exception {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        boolean flag =true;
        while (flag){
            out.write("\nplease inupt your command:".getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String commmand = reader.readLine();
            try {
                StringBuilder sb = customerController.excuteCommand(commmand);
                out.write(sb.toString().getBytes());
            }catch (FormatException ex){
                out.write("input error!".getBytes());
            }
            if(commmand.equals("exit")){
                flag = false;
            }
        }
        out.close();
        in.close();
        socket.close();
        server.close();
    }
}
