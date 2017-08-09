package dao;

import pojo.User;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public interface UserDao {
    boolean Register(User user);
    User login(String name, String password);
}
