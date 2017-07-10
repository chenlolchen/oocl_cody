package com.oocl.handle_data.repository.impl;

import com.oocl.handle_data.compare.CustomerDateComparator;
import com.oocl.handle_data.compare.CustomerIdComparator;
import com.oocl.handle_data.db.CustomerFactory;
import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.repository.CustomerDataProcess;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerDataProcessImpl implements CustomerDataProcess {
    public Set<Customer> customerSet;

    public CustomerDataProcessImpl(){
        customerSet = CustomerFactory.getInstance();
    }

    public void add(Customer customer) {
        customerSet.add(customer);
    }

    public void add(String[] str) {
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(str[0]));
        customer.setName(str[1]);
        customer.setEmail(str[2]);
        customer.setSex(Boolean.valueOf(str[3]));
        customer.setBirthDay(str[4]);
        customerSet.add(customer);
    }

    public Set<Customer> outputBySortId() {
        Set<Customer> set = new TreeSet<Customer>(new CustomerIdComparator());
        for(Customer customer : customerSet){
            set.add(customer);
        }
        return set;
    }

    public Set<Customer> outputBySortDate(){
        Set<Customer> set = new TreeSet<Customer>(new CustomerDateComparator());
        for(Customer customer : customerSet){
            set.add(customer);
        }
        return set;
    }
}
