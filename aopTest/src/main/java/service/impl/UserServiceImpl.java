package service.impl;

import dao.UserDao;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    public boolean register(User user) {
        return userDao.register(user);
    }

    public User login(String name, String password) {
        return userDao.login(name, password);
    }
}
