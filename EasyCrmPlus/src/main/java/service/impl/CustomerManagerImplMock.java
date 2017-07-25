package service.impl;

import pojo.Customer;
import service.CustomerManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class CustomerManagerImplMock implements CustomerManager {
    private List<Customer> list = new ArrayList<Customer>();

    public CustomerManagerImplMock(){
        Customer c = new Customer(null, "tom", 357.89, true, new Date(), new String[]{"basketball, football"});
        list.add(c);
    }

    public int addCustomer(Customer customer) {
        list.add(customer);
        return 1;
    }

    public List<Customer> findAllCustomers() {
        return list;
    }

    public List<String> getFavsById(int id) {
        List<String> favs = new ArrayList<String>();
        favs.add("basketball");
        return favs;
    }

    public int delCustomerById(int id) {
        return 0;
    }

    public Customer loadCustomer(int id) {
        return null;
    }

    public int updateCustomer(Customer customer) {
        return 0;
    }
}
