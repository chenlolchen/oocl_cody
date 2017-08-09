package service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class UserServiceFactory {
    private static UserService service;

    public static UserService getInstance(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = context.getBean(UserService.class);
        return service;
    }
}
