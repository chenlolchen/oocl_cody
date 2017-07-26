package shop_store.dao.impl;

import shop_store.dao.CustomerDao;
import shop_store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    public shop_store.pojo.Customer loadUser(String name, String password) {
        String sql = "select * from customers where name = ? and password = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        shop_store.pojo.Customer customer = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                customer = new shop_store.pojo.Customer();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return customer;
    }
}
