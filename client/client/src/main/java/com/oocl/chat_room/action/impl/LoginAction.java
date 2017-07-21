package com.oocl.chat_room.action.impl;

import com.oocl.chat_room.action.Action;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.ui.LoginFrame;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class LoginAction implements Action {
    private LoginFrame loginFrame;
    private DataPackageAnalyser dataPackageAnalyser;

    public LoginAction(Socket socket, LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    @Override
    public void handleDataPackage(DataPackage dataPackage) {
        if (dataPackage == null) {
            dataPackageAnalyser.closeSession();
            return;
        }
        if (dataPackage.getMessageType() == DataPackage.MessageType.LOGIN) {
            if (dataPackage.getMessageData().equals("success")) {
                User user = new User(dataPackage.getFromName());
                loginFrame.setFlag(false);
                dataPackageAnalyser.closeSession();
                loginFrame.showChatFrameUI(user);
            } else if (dataPackage.getMessageData().equals("error")) {
                loginFrame.showErrorDialog();
            }
        }
    }

    @Override
    public void sendDataPackage(DataPackage dataPackage) {
        if (!dataPackageAnalyser.sendPackage(dataPackage)) {
            loginFrame.setTitle("服务器没响应");
        }
    }

    @Override
    public DataPackage receiveDataPackage() {
        DataPackage dataPackage = null;
        try {
            dataPackage = dataPackageAnalyser.readPackage();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return dataPackage;
        }
    }
}
