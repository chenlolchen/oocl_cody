package dao;

import pojo.User;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
public interface UserDao {
    User addUser(User user);
    User loadUser(String name, String password);
}
