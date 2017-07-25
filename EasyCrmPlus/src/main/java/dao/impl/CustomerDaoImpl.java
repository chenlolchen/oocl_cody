package dao.impl;

import dao.CustomerDao;
import pojo.Customer;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    public int addCustomer(Customer customer) {
        String sql = "insert into customers(id, name, sal, birth, sex) values(seq01.nextval, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql, new String[] {"ID"});
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDouble(2, customer.getSal());
            preparedStatement.setDate(3, new java.sql.Date(customer.getBirth().getTime()));
            preparedStatement.setBoolean(4, customer.isSex());
            m = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                String[] favs = customer.getFavs();
                System.out.println(favs[0]);
                for(String fav : favs){
                    String sql2 = "insert into favs(id, fav_name, customer_id) values (seq02.nextval, ?, ?)";
                    preparedStatement = connection.prepareStatement(sql2);
                    preparedStatement.setString(1, fav);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        String sql = "select * from customers";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setBirth(rs.getDate("birth"));
                customer.setSal(rs.getDouble("sal"));
                customer.setSex(rs.getBoolean("sex"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }

    public List<String> getFavsById(int id) {
        String sql = "select * from favs where customer_id = ?";
        List<String> favs = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                String fav_name = rs.getString("fav_name");
                favs.add(fav_name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return favs;
    }

    public int delCustomerById(int id) {
        String sql = "delete from favs where customer_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            String sql2 = "delete from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, id);
            m = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public Customer loadCustomer(int id) {
        String sql = "select * from customers where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Customer customer = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSex(rs.getBoolean("sex"));
                customer.setSal(rs.getDouble("sal"));
                customer.setBirth(rs.getDate("birth"));
                String sql2 = "select * from favs where customer_id = ?";
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1, id);
                rs = preparedStatement.executeQuery();
                List<String> list = new ArrayList<String>();
                if(rs.next()){
                    list.add(rs.getString("fav_name"));
                }
                int size = list.size();
                String[] favs = new String[size];
                for(int i = 0; i < size; i++){
                    favs[i] = list.get(i);
                }
                customer.setFavs(favs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return customer;
    }

    public int updateCustomer(Customer customer) {
        String sql = "update customers set name = ?, sal = ?, birth = ?, sex = ? where id = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDouble(2, customer.getSal());
            preparedStatement.setDate(3, new java.sql.Date(customer.getBirth().getTime()));
            preparedStatement.setBoolean(4, customer.isSex());
            preparedStatement.setInt(5, customer.getId());
            m = preparedStatement.executeUpdate();

            String sql2 = "delete from favs where customer_id = ?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.executeUpdate();

            String[] favs = customer.getFavs();
            for(String fav : favs){
                String sql3 = "insert into favs(id, fav_name, customer_id) values (seq02.nextval, ?, ?)";
                preparedStatement = connection.prepareStatement(sql3);
                preparedStatement.setString(1, fav);
                preparedStatement.setInt(2, customer.getId());
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }
}
