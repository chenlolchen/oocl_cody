package com.oocl.jdbc.dao.impl;

import com.oocl.jdbc.dao.CustomerDao;
import com.oocl.jdbc.pojo.Customer;
import com.oocl.jdbc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO customers(id, cname, sex, birth, sal) VALUES (seq01.nextval,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCname());
            preparedStatement.setBoolean(2, customer.isSex());
            preparedStatement.setDate(3, new java.sql.Date(customer.getBirth().getTime()));
            preparedStatement.setDouble(4, customer.getSal());
            m = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, preparedStatement, null);
        }
        return m;
    }

    public int deleteCustomer(Integer id) {
        String sql = "delete customers where id = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public int updateCustomer(Customer customer) {
        String sql = "update customers set cname = ?, sex = ?, sal = ?, birth = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCname());
            preparedStatement.setBoolean(2, customer.isSex());
            preparedStatement.setDouble(3, customer.getSal());
            preparedStatement.setDate(4, new Date(customer.getBirth().getTime()));
            preparedStatement.setInt(5, customer.getId());
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public Customer loadCustomer(Integer id) {
        String sql = "select * from customers where id = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setCname(resultSet.getString("cname"));
                customer.setSal(resultSet.getDouble("sal"));
                customer.setBirth(resultSet.getDate("birth"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return customer;
    }

    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<Customer>();
        String sql = "select * from customers";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            statement = connection.prepareStatement(sql);
            // rs: 二维表
            rs = statement.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCname(rs.getString("cname")); //使用的是别名
                customer.setSex(rs.getBoolean("sex"));
                customer.setSal(rs.getDouble("sal"));
                customer.setBirth(rs.getDate("birth"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;
    }
}
