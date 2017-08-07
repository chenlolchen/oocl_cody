package service.impl;

import pojo.Customer;
import service.CustomerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
public class CustomerManagerImpl implements CustomerManager {
    private final List<Customer> customers = new ArrayList<Customer>();

    public Customer addCustomer(Customer customer) {
        synchronized (customers){
            customer.setId(UUID.randomUUID().toString());
            customers.add(customer);
        }
        return customer;
    }

    public List<Customer> findAllCustomers() {
        return customers;
    }
}
