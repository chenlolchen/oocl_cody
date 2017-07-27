package store.dao;

import store.pojo.Store;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public interface StoreDao {
    List<Store> findAllStores();
}
