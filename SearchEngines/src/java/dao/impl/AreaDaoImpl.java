package dao.impl;

import dao.AreaDao;
import pojo.Area;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class AreaDaoImpl implements AreaDao {

    public List<Area> searchAreaByName(String areaName) {
        List<Area> list = new ArrayList<Area>();
        String sql = "select * from areas where area like ? AND ROWNUM <= 5";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + areaName + "%");
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Area area = new Area();
                area.setId(rs.getInt("id"));
                area.setAreaId(rs.getString("areaid"));
                area.setArea(rs.getString("area"));
                area.setCityId(rs.getString("cityid"));
                list.add(area);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }
}
