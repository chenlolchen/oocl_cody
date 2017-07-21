package com.oocl.chat_room.service.register.impl;

import java.util.List;

import com.oocl.chat_room.dao.UserDao;
import com.oocl.chat_room.dao.impl.UserDaoImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;
import com.oocl.chat_room.service.register.RegisterService;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class RegisterServiceImpl implements RegisterService {
    private UserDao userDao;

    public RegisterServiceImpl(){
        this.userDao = new UserDaoImpl();
    }

    @Override
    public DataPackage getRegisterDataPackage(DataPackage dataPackage) {
        User user = new User();
        user.setName(dataPackage.getFromName());
        user.setPassword(dataPackage.getMessageData());
        user.setStatus(false);
        if(userDao.addUser(user) > 0){
            return new DataPackage(dataPackage.getFromName(),dataPackage.getToName(), DataPackage.MessageType.REGISTER, "success");
        }else {
            return new DataPackage(dataPackage.getFromName(),dataPackage.getToName(), DataPackage.MessageType.REGISTER, "register error");
        }
    }
    
    public List<User> getUserList(){
    	return userDao.showUserList();
    }
}
