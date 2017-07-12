package com.oocl.tcp;

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
        while (true){
            Socket socket = server.accept();
            OutputStream out = socket.getOutputStream();
            BufferedOutputStream bo = new BufferedOutputStream(out);
            InputStream in = socket.getInputStream();
            out.write("please input file name:?\n".getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String name = reader.readLine();
            System.out.println(name);

            File file = new File(PATH + name);
            if (file.exists()){
                out.write("200 OK\n".getBytes());

//                没使用buffer
//                InputStream f = new FileInputStream(file);
//                byte[] b = new byte[4];
//                int len = 0;
//                while ((len = f.read(b)) != -1){
//                    out.write(b,0,len);
//                }

                //使用buffuered
                BufferedInputStream f = new BufferedInputStream(new FileInputStream(file));
                int m;
                while ((m = f.read()) != -1){
                    bo.write((byte)m);
                }
                bo.flush();
            }else {
                out.write(("file not found, please input your file name:\n").getBytes());
                name = reader.readLine();
                file = new File(PATH + name);
            }
            out.close();
            in.close();
            socket.close();
        }
    }
}
