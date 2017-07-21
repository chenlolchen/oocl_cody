package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.ui.RegisterFrame;

import java.net.Socket;

public class RegisterAction {

    private DataPackageAnalyser registerDataPackageAnalyser;
    private RegisterFrame registerFrame;

    public RegisterAction(Socket socket, RegisterFrame registerFrame) {
        this.registerDataPackageAnalyser = new DataPackageAnalyserImpl(socket);
        this.registerFrame = registerFrame;
    }


    public void handleDataPackage(DataPackage dataPackage) {
        if (dataPackage == null) {
            registerDataPackageAnalyser.closeSession();
            return;
        }
        if (dataPackage.getMessageType() == DataPackage.MessageType.REGISTER) {
            System.out.println(dataPackage);
            if (dataPackage.getMessageData().equals("success")) {
                registerFrame.setFlag(false);
                registerDataPackageAnalyser.sendPackage(new DataPackage(dataPackage.getFromName(), dataPackage.getToName(), DataPackage.MessageType.REGISTER, "OK"));
                registerDataPackageAnalyser.closeSession();
                registerFrame.showSuccessDialog();
            } else if (dataPackage.getMessageData().equals("register error")) {
                registerFrame.showErrorDialog();
            }
        }
    }

    public void sendDataPackage(DataPackage dataPackage) {
        if (!registerDataPackageAnalyser.sendPackage(dataPackage)) {
            registerFrame.setTitle("服务器没响应");
        }
    }

    public DataPackage receiveDataPackage() {
        DataPackage dataPackage = null;
        try {
            dataPackage = registerDataPackageAnalyser.readPackage();
            System.out.println("接受：" + dataPackage.toString());
        } catch (Exception ex) {
            registerFrame.setTitle(("server is down"));
        } finally {
            return dataPackage;
        }
    }

}
