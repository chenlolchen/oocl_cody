package com.oocl.chat_room.dao;

import com.oocl.chat_room.pojo.User;

import java.util.List;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public interface UserDao {
    int updateUser(User user);

    int addUser(User user);

    List<User> showUserList();

    User getUserByName(String name);

    boolean checkUser(User user);

    User loadUser(String name, String password);
}
