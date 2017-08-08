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

    public Customer updateCustomer(Customer customer){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId().equals(customer.getId())){
                customers.remove(i);
                customers.add(i, customer);
                return customer;
            }
        }
        return null;
    }

    public Customer deleteCustomerById(String id) {
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId().equals(id)){
                Customer customer = customers.get(i);
                customers.remove(i);
                return customer;
            }
        }
        return null;
    }

    public Customer loadCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
