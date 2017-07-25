package service.impl;

import service.CustomerManager;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class CustomerManagerFactory {
    private static CustomerManager manager;

    public static CustomerManager getInstance(){
        if (manager == null){
            manager = new CustomerManagerImpl();
        }
        return manager;
    }
}
