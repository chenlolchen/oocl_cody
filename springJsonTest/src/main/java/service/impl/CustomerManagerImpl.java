package service.impl;

import pojo.Customer;
import service.CustomerManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
public class CustomerManagerImpl implements CustomerManager {
    private final List<Customer> customers = new ArrayList<Customer>();

    public CustomerManagerImpl(){
        Customer c1 = new Customer(UUID.randomUUID().toString(), "chen", true, 27.61, new Date());
        Customer c2 = new Customer(UUID.randomUUID().toString(), "asd", false, 74.61, new Date());
        customers.add(c1);
        customers.add(c2);
    }

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
        synchronized (customers){
            int index = customers.indexOf(customer);
            customers.set(index, customer);
        }
        return null;
    }

    public String deleteCustomerById(String id) {
        synchronized (customers) {
            Customer c=new Customer();
            c.setId(id);
            customers.remove(c);
        }
        return "{}";
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
