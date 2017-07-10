package com.oocl.handle_data.repository;

import com.oocl.handle_data.pojo.Customer;

import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public interface CustomerDataProcess {
    void add(String[] str);

    Set<Customer> outputBySortId();

    Set<Customer> outputBySortDate();

}
