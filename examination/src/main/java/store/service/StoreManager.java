package store.service;


import store.pojo.Store;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public interface StoreManager {
    List<Store> findAllStores();
}
