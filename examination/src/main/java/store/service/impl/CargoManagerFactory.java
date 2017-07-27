package store.service.impl;


import store.service.CargoManager;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CargoManagerFactory {
    private static CargoManager manager;

    public static CargoManager getInstance(){
        if (manager == null){
            manager = new CargoManagerImpl();
        }
        return manager;
    }
}
