package com.oocl.chat_room.analyser.impl;

import java.io.*;
import java.net.Socket;

import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.util.JsonUtil;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class DataPackageAnalyserImpl implements DataPackageAnalyser {
    private DataOutputStream writer;
    private DataInputStream reader;
    private Socket socket;

    public DataPackageAnalyserImpl() {

    }

    public DataPackageAnalyserImpl(Socket socket) {
        try {
            this.socket = socket;
            writer = new DataOutputStream(socket.getOutputStream());
            reader = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DataPackage readPackage() throws Exception {
        DataPackage dataPackage = null;
        String message = reader.readUTF();
        dataPackage = (DataPackage) JsonUtil.toJsonObject(message, DataPackage.class);
        return dataPackage;
    }

    @Override
    public Boolean sendPackage(DataPackage dataPackage) {
        if (socket.isClosed()) {
            return false;
        }
        try {
            String sendMessage = JsonUtil.toJsonString(dataPackage);
            writer.writeUTF(sendMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void closeSession() {
        try {
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
