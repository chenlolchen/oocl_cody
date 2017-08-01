package service;

import dao.AreaDao;
import dao.impl.AreaDaoImpl;
import pojo.Area;

import java.util.List;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class AreaManagerImpl implements AreaManager {
    private AreaDao areaDao;

    public AreaManagerImpl(){
        areaDao = new AreaDaoImpl();
    }

    public List<Area> searchAreaByName(String areaName) {
        return areaDao.searchAreaByName(areaName);
    }
}
