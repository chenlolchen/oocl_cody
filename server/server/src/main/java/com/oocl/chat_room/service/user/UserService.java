package com.oocl.chat_room.service.user;

import com.oocl.chat_room.pojo.User;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public interface UserService {
    User getUserByName(String name);

	void updateUser(User user);


    User loadUser(String name, String password);
}
