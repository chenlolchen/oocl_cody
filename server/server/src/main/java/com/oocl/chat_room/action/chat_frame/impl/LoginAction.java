package com.oocl.chat_room.action.chat_frame.impl;

import com.oocl.chat_room.action.chat_frame.Action;
import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.analyser.impl.DataPackageAnalyserImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.server.thread.LoginSocket;
import com.oocl.chat_room.service.user.UserService;
import com.oocl.chat_room.service.user.impl.UserServiceImpl;

import java.net.Socket;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class LoginAction implements Action {
    private LoginSocket loginSocket;
    private DataPackageAnalyser dataPackageAnalyser;
    private UserService userService;

    public LoginAction(Socket socket, LoginSocket loginSocket){
        this.loginSocket = loginSocket;
        this.userService = new UserServiceImpl();
        this.dataPackageAnalyser = new DataPackageAnalyserImpl(socket);
    }

    @Override
    public void handleDataPackage(DataPackage dataPackage) {
        if (dataPackage == null){
            dataPackageAnalyser.closeSession();
            loginSocket.setFlag(false);
        }
        else if(dataPackage.getMessageType() == DataPackage.MessageType.LOGIN){
            System.out.println(dataPackage);
            if(dataPackage.getMessageData().equals("OK")){
                loginSocket.setFlag(false);
            }else {
                User user = userService.loadUser(dataPackage.getFromName(), dataPackage.getMessageData());
//                User user = userService.getUserByName(dataPackage.getFromName());
                if(user != null){
                	user.setStatus(true);
                    userService.updateUser(user);
                    loginSocket.setFlag(false);
                    loginSocket.send(new DataPackage(dataPackage.getFromName(), dataPackage.getToName(), DataPackage.MessageType.LOGIN, "success"));
                }else {
                    loginSocket.send(new DataPackage(dataPackage.getFromName(), dataPackage.getToName(), DataPackage.MessageType.LOGIN, "error"));
                }
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
        }catch (Exception ex){
            System.out.println("user auto close");
        }
        return dataPackage;
    }
}
