package service.impl;

import dao.CustomerDao;
import org.springframework.stereotype.Service;
import pojo.Customer;
import service.CustomerManager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
@Service
public class CustomerManagerImpl implements CustomerManager {
    @Resource
    private CustomerDao customerDao;

    public CustomerManagerImpl() {

    }

    public Customer addCustomer(Customer customer) {
        synchronized (this) {
            customer.setId(UUID.randomUUID().toString());
            return customerDao.addCustomer(customer);
        }
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

    public Customer updateCustomer(Customer customer) {
        synchronized (this) {
            return customerDao.updateCustomer(customer);
        }
    }

    public String deleteCustomerById(String id) {
        synchronized (this) {
            return customerDao.deleteCustomerById(id);
        }
    }

    public Customer loadCustomerById(String id) {
        return customerDao.loadCustomerById(id);
    }
}
