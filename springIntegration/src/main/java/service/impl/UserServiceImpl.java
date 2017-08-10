package service.impl;

import dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;
import javax.persistence.Transient;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Transactional
    public User register(User user) {
        System.out.println(user);
        return userDao.addUser(user);
    }

    public User login(String name, String password) {
        return userDao.loadUser(name, password);
    }
}
