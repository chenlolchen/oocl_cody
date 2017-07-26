package shop_store.service.impl;

import shop_store.service.OrderManager;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class OrderManagerFactory {
    private static OrderManager manager;

    public static OrderManager getInstance(){
        if (manager == null){
            manager = new OrderManagerImpl();
        }
        return manager;
    }
}
