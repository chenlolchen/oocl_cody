package com.oocl.db;

import com.oocl.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class UserListFactory {
    public static HashMap<String,User> getInstance() {
        HashMap<String,User> map = new HashMap<String, User>();
        return map;
    }
}
