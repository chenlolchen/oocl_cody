package store.service.impl;

import store.dao.StoreDao;
import store.dao.impl.StoreDaoImpl;
import store.pojo.Store;
import store.service.StoreManager;

import java.util.List;


/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class StoreManagerImpl implements StoreManager {
    private StoreDao storeDao;

    public StoreManagerImpl() {
        this.storeDao = new StoreDaoImpl();
    }

    public List<Store> findAllStores() {
        return storeDao.findAllStores();
    }
}
