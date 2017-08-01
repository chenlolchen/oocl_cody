package dao.impl;

import dao.AreaDao;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DBUtil;


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

    }

}