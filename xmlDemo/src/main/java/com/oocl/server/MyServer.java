package com.oocl.server;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class MyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream out = socket.getOutputStream();

        String line = null;
        while ((line = reader.readLine()).trim().length() != 0){
            System.out.println(line);
        }

        System.out.println("header end ...");
//        char[] chars = new char[17];
//        int len = reader.read(chars);
//        String requestBody = new String(chars, 0 , len);
//        System.out.println(requestBody);

        Document dom = new Document();
        Element root = new Element("html");
        Element body = new Element("body");
        Element button = new Element("button");
        button.setText("find");
        body.addContent(button);
        root.addContent(body);
        dom.setRootElement(root);

        XMLOutputter outputter = new XMLOutputter();
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        outputter.output(root, out);


        out.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
