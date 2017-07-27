package store.dao.impl;


import store.dao.CustomerDao;
import store.pojo.Customer;
import store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    public Customer loadUser(String name, String password) {
        String sql = "select * from customers where name = ? and password = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Customer customer = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                customer = new Customer();
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
