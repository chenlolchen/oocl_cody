package service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerManager;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
public class CustomerManagerFactory {
    private static CustomerManager manager;

    public static CustomerManager getInstance(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        manager = context.getBean(CustomerManager.class);
        return manager;
    }

//    static {
//        manager = new CustomerManagerImpl();
//    }
//
//    public static CustomerManager getInstance(){
//        return manager;
//    }
}
