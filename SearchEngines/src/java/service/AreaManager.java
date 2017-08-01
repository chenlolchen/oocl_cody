package service;

import pojo.Area;

import java.util.List;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public interface AreaManager {
    List<Area> searchAreaByName(String areaName);
}
