package com.oocl.chat_room.test;

import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.protocol.DataPackage;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by chen on 2017/7/16.
 */
public class TestServer {
    public static void main(String[] args) {
        //需要先启动服务器
        DataPackageAnalyser dataPackageAnalyser = null;
        try {
            dataPackageAnalyser = new DataPackageAnalyserImpl(new Socket("127.0.0.1", 8888));
            // 模拟客户端往服务端发送消息
            dataPackageAnalyser.sendPackage(new DataPackage("test", "server", DataPackage.MessageType.LOGIN, "this is test login"));
            System.out.println(dataPackageAnalyser.readPackage());
            dataPackageAnalyser.sendPackage(new DataPackage("test", "server", DataPackage.MessageType.LOGOUT, "this is test logout"));
            System.out.println(dataPackageAnalyser.readPackage());
        } catch (Exception e) {
            System.out.println("需要先启动服务器");
        }
    }
}
