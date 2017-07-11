package com.oocl.handle_data;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.controller.impl.CustomerControllerImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Application {
    public static void main(String[] args) throws Exception {
        CustomerController customerController = new CustomerControllerImpl();
        customerController.scanner("data.txt");
//        System.out.println("sort by id:");
//        customerController.outputBySortId();
//        System.out.println("sort by date:");
//        customerController.outputBySortDate();
//        System.out.println("output xml:");
//        customerController.outputXml();
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        boolean flag =true;
        while (flag){
            out.write("\nplease inupt your command:".getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String commmand = reader.readLine();
            customerController.excuteCommand(commmand);
            StringBuilder sb = new StringBuilder();
            sb.append("aaaa");
            out.write(commmand.getBytes());
            out.write(sb.toString().getBytes());
            if(commmand.equals("exit")){
                flag = false;
            }
        }
//        char name = (char)in.read();
//        System.out.println(name);
        out.close();
        in.close();
        socket.close();
        server.close();
    }
}
