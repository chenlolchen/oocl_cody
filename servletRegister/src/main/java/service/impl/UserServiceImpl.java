package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int addUser(String name, String birth, String salary, String sex) {
        User user = new User();
        user.setName(name);
        user.setSalary(Double.valueOf(salary));
        user.setSex(Boolean.valueOf(sex));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirth(date);

        return userDao.addUser(user);
    }

    public User loadUser(String name) {
        return userDao.loadUser(name);
    }

    public int addUser2(String name, String birth, String salary, String sex, byte[] avatar) {
        User user = new User();
        user.setName(name);
        user.setSalary(Double.valueOf(salary));
        user.setSex(Boolean.valueOf(sex));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        System.out.println("dddddddddddddddddddddd");
        try {
            date = format.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirth(date);
        user.setAvatar(avatar);

        return userDao.addUser2(user);
    }
}
