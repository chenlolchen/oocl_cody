package com.oocl.handle_data.service;

import com.oocl.handle_data.pojo.Customer;

import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public interface CustomerService {
    Set<Customer> outputBySortId();

    Set<Customer> outputBySortDate();

    void insertData(String s);
}
