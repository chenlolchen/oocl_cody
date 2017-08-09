package service;

import pojo.User;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public interface UserService {
    boolean register(User user);
    User login(String name, String password);
}
