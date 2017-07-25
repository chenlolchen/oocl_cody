package service;

import pojo.User;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public interface UserService {
    int addUser(String name,String birth, String salary, String sex);
    User loadUser(String name);
    int addUser2(String name,String birth, String salary, String sex, byte[] avatar);
}
