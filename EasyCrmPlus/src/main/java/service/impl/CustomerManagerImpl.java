package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import pojo.Customer;
import service.CustomerManager;

import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class CustomerManagerImpl implements CustomerManager {
    private CustomerDao customerDao;

    public CustomerManagerImpl(){
        this.customerDao = new CustomerDaoImpl();
    }

    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

    public List<String> getFavsById(int id) {
        return customerDao.getFavsById(id);
    }

    public int delCustomerById(int id) {
        return customerDao.delCustomerById(id);
    }

    public Customer loadCustomer(int id) {
        return customerDao.loadCustomer(id);
    }

    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}
