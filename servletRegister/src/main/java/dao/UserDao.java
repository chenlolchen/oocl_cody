package dao;

import pojo.User;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public interface UserDao {
    int addUser(User user);
    User loadUser(String name);
}
