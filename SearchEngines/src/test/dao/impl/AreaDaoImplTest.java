package dao.impl;

import dao.AreaDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Area;
import util.DBUtil;

import java.util.List;


/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class AreaDaoImplTest {

    private static AreaDao areaDao;

    @BeforeClass
    public static void init() {
        DBUtil.setDBCPBds();
        areaDao = new AreaDaoImpl();
    }

    @Test
    public void searchAreaByName() throws Exception {
        List<Area> list = areaDao.searchAreaByName("区");
        Assert.assertNotNull(list);
        for (Area area : list){
            System.out.println(area);
        }

        List<Area> list2 = areaDao.searchAreaByName("区23231");
        Assert.assertTrue(list2.isEmpty());
    }

}