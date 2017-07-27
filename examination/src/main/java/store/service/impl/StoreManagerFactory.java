package store.service.impl;


import store.service.StoreManager;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class StoreManagerFactory {
    private static StoreManager manager;

    public static StoreManager getInstance(){
        if (manager == null){
            manager = new StoreManagerImpl();
        }
        return manager;
    }
}
