package store.dao.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import store.dao.CargoDao;
import store.pojo.Cargo;
import store.util.DBUtil;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
public class CargoDaoImplTest {
    private static CargoDao cargoDao;

    @BeforeClass
    public static void init() {
        DBUtil.setDBCPBds();
        cargoDao = new CargoDaoImpl();
    }

    @Test
    public void addCargo() throws Exception {
        Assert.assertTrue(cargoDao.addCargo(new Cargo("72ab6e2a-bf43-42ee-bbf3-18ea25d71b0d", "test", 56.32, 666, new Date(), "8bb02db2-2e22-4da7-b4f4-f9c20f8f35ce")) == 1);
    }

    @Test
    public void getCargoListByStoreId() throws Exception {
        Assert.assertNotNull(cargoDao.getCargoListByStoreId("1d6a2991-b8d9-4469-9259-1c9ca76e6a0d"));
    }

    @Test
    public void deleteCargoById() throws Exception {
        Assert.assertTrue(cargoDao.deleteCargoById("72ab6e2a-bf43-42ee-bbf3-18ea25d71b0d") == 1);
    }

    @Test
    public void loadCargo() throws Exception {
        Assert.assertNotNull(cargoDao.loadCargo("72ab6e2a-bf43-42ee-bbf3-18ea25d71b0d"));
    }

    @Test
    public void updateCargo() throws Exception {
        Assert.assertTrue(cargoDao.updateCargo(new Cargo("72ab6e2a-bf43-42ee-bbf3-18ea25d71b0d", "test", 56.32, 888, new Date(), "8bb02db2-2e22-4da7-b4f4-f9c20f8f35ce")) == 1);
    }

}