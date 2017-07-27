package store.dao.impl;

import store.dao.StoreDao;
import store.pojo.Store;
import store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class StoreDaoImpl implements StoreDao{

    public List<Store> findAllStores() {
        List<Store> list = new ArrayList<Store>();
        String sql = "select * from stores";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Store store = new Store();
                store.setId(rs.getString("id"));
                store.setAddress(rs.getString("address"));
                list.add(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }
}
