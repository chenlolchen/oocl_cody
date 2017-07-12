package com.oocl.scp_ssh.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String cmd = null;
        System.out.println(reader.readLine());

        boolean flag = true;
        while (flag){
            cmd = scanner.nextLine();
            out.write((cmd + "\n").getBytes());
            System.out.println(reader.readLine());

            if(cmd.equals("exit")){
                flag = false;
            }
        }

        reader.close();
        socket.close();
    }
}
