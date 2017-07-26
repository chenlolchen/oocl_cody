package service;

import pojo.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CustomerServiceImpl {
    private List<Customer> list;

    public CustomerServiceImpl(){
        list = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setName("john");
        customer.setPassword("123");
        Customer customer2 = new Customer();
        customer.setName("cody");
        customer.setPassword("456");
        list.add(customer);
        list.add(customer2);
    }

    public Customer loadCustomer(String name, String password){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        for(Customer c : list){
            if (c.getName().equals(customer.getName())){
                return customer;
            }
        }
        return null;
    }
}
