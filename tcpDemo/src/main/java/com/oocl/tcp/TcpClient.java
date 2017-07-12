package com.oocl.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TcpClient {
    public static void main(String[] args) throws Exception {
        final String PATH = "download/";
        Socket socket = new Socket("127.0.0.1", 8888);
        InputStream in = socket.getInputStream();
        BufferedInputStream ins = new BufferedInputStream(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String line = null;
        String file_name = null;
        while (!"200 OK".equals(line = reader.readLine())) {
            System.out.println(line);
            file_name = scanner.next();
            out.write((file_name + "\n").getBytes());
        }

        //使用缓存
        BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(PATH + file_name));
        int len = 0;
        while ((len = ins.read()) != -1){
            fo.write((byte) len);
        }

//        没用缓存
//        FileOutputStream fo = new FileOutputStream(PATH + file_name);
//        byte[] buf = new byte[4];
//        int len = 0;
//        while ((len = in.read(buf)) != -1) {
//            fo.write(buf);
//        }

        fo.close();
        reader.close();
        socket.close();
    }
}
