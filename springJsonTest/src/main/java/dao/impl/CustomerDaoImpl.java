package dao.impl;

import dao.CustomerDao;
import org.springframework.stereotype.Repository;
import pojo.Customer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Resource(name = "dataSource1")
    private DataSource dataSource;

    public Customer addCustomer(Customer customer) {
        try {
            String sql = "insert into customers(id, name, sex, salary, birth) values(?, ?, ?, ?, ?)";
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setBoolean(3, customer.isSex());
                preparedStatement.setDouble(4, customer.getSalary());
                preparedStatement.setDate(5, new Date(customer.getBirth().getTime()));
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement.close();
                connection.close();
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> findAllCustomers() {
        try {
            List<Customer> list = new ArrayList<Customer>();
            String sql = "select * from customers";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getString("id"));
                    customer.setName(rs.getString("name"));
                    customer.setSex(rs.getBoolean("sex"));
                    customer.setSalary(rs.getDouble("salary"));
                    customer.setBirth(rs.getDate("birth"));
                    list.add(customer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        try {
            String sql = "update customers set name = ?, sex = ?, salary = ?, birth = ? where id = ?";
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setBoolean(2, customer.isSex());
                preparedStatement.setDouble(3, customer.getSalary());
                preparedStatement.setDate(4, new Date(customer.getBirth().getTime()));
                preparedStatement.setString(5, customer.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement.close();
                connection.close();
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteCustomerById(String id) {
        try {
            String sql = "delete customers where id = ?";
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public Customer loadCustomerById(String id) {
        try {
            String sql = "select * from customers where id = ?";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getString("id"));
                    customer.setName(rs.getString("name"));
                    customer.setSex(rs.getBoolean("sex"));
                    customer.setSalary(rs.getDouble("salary"));
                    customer.setBirth(rs.getDate("birth"));
                    return customer;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
