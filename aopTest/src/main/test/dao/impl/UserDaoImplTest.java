package dao.impl;

import dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import util.MD5Util;

import javax.sql.DataSource;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class UserDaoImplTest {
    private UserDao userDao;
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Before
    public void setUp(){
        userDao = context.getBean(UserDao.class);
    }

    @Test
    public void register() throws Exception {
        User user = new User(UUID.randomUUID().toString(), "chen", MD5Util.getMD5("ooo"), 23);
        Assert.assertTrue(userDao.register(user));
    }

    @Test
    public void login() throws Exception {
        User user = userDao.login("chen", MD5Util.getMD5("ooo"));
        Assert.assertNotNull(user);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

}