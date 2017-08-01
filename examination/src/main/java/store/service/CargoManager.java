package store.service;


import store.pojo.Cargo;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public interface CargoManager {
    int addCargo(Cargo cargo);

    List<Cargo> getCargoListByStoreId(String storeId);

    int deleteCargoById(String deleteId);

    Cargo loadCargo(String id);

    int updateCargo(Cargo cargo);
}