package service;

import pojo.User;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
public interface UserService {
    User register(User user);
    User login(String name, String password);
}
