package com.oocl.chat_room.action.chat_frame.impl;

import com.oocl.chat_room.action.chat_frame.Action;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.RegisterSocket;
import com.oocl.chat_room.service.register.RegisterService;
import com.oocl.chat_room.service.register.impl.RegisterServiceImpl;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class RegisterAction implements Action {
    private RegisterSocket registerSocket;
    private DataPackageAnalyser dataPackageAnalyser;
    private RegisterService registerService;

    public RegisterAction(Socket socket, RegisterSocket registerSocket) {
        this.registerSocket = registerSocket;
        this.registerService = new RegisterServiceImpl();
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    @Override
    public void handleDataPackage(DataPackage dataPackage) {
        if (dataPackage == null) {
            dataPackageAnalyser.closeSession();
            registerSocket.setFlag(false);
        } else if (dataPackage.getMessageType() == DataPackage.MessageType.REGISTER) {
            if (dataPackage.getMessageData().equals("OK")) {
                registerSocket.setFlag(false);
            } else {
                DataPackage sendPackage = registerService.getRegisterDataPackage(dataPackage);
                registerSocket.send(sendPackage);
            }
        }
    }

    @Override
    public void sendDataPackage(DataPackage dataPackage) {
        dataPackageAnalyser.sendPackage(dataPackage);
    }

    @Override
    public DataPackage receiveDataPackage() {
        DataPackage dataPackage = null;
        try {
            dataPackage = dataPackageAnalyser.readPackage();
        } catch (Exception ex) {
            System.out.println("register auto close");
        }
        return dataPackage;
    }
}
