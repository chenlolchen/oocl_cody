package com.oocl.chat_room.service.user.impl;

import com.oocl.chat_room.dao.UserDao;
import com.oocl.chat_room.dao.impl.UserDaoImpl;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.service.user.UserService;

/**
 * Created by CHENCO7 on 7/20/2017.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

	@Override
	public void updateUser(User user) {
		 userDao.updateUser(user);
	}

    @Override
    public User loadUser(String name, String password) {
        return userDao.loadUser(name, password);
    }
}
