package service;

import pojo.Customer;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CustomerServiceImpl {
    private List<Customer> list;

    public CustomerServiceImpl(){
        Customer customer = new Customer();
        customer.setName("");
        list.add()
    }

    public Customer loadCustomer(String name, String password){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        return customer;
    }
}
