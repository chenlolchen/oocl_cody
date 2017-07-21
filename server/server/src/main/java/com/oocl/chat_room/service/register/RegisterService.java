package com.oocl.chat_room.service.register;

import java.util.List;

import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public interface RegisterService {

    DataPackage getRegisterDataPackage(DataPackage dataPackage);
    
    List<User> getUserList();
}
