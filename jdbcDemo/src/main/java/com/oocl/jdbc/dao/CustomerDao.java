package com.oocl.jdbc.dao;

import com.oocl.jdbc.pojo.Customer;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public interface CustomerDao {
    public int addCustomer(Customer customer);
    public int deleteCustomer(Integer id);
    public int updateCustomer(Customer customer);
    public Customer loadCustomer(Integer id);
    public List<Customer> findAll(); // 条件, 分页, 可扩展
}
