package store.service.impl;

import store.dao.CargoDao;
import store.dao.impl.CargoDaoImpl;
import store.pojo.Cargo;
import store.service.CargoManager;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CargoManagerImpl implements CargoManager {
    private CargoDao cargoDao;

    public CargoManagerImpl(){
        cargoDao = new CargoDaoImpl();
    }

    public int addCargo(Cargo cargo) {
        return cargoDao.addCargo(cargo);
    }

    public List<Cargo> getCargoListByStoreId(String storeId) {
        return cargoDao.getCargoListByStoreId(storeId);
    }

    public int deleteCargoById(String deleteId) {
        return cargoDao.deleteCargoById(deleteId);
    }

    public Cargo loadCargo(String id) {
        return cargoDao.loadCargo(id);
    }

    public int updateCargo(Cargo cargo) {
        return cargoDao.updateCargo(cargo);
    }
}
