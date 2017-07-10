package com.oocl.handle_data.db;

import com.oocl.handle_data.pojo.Customer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerFactory {
    private static Set<Customer> customerSet;

    public static Set<Customer> getInstance(){
        customerSet = new HashSet<Customer>();
        return customerSet;
    }
}
