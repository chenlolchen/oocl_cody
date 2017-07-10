package com.oocl.handle_data.compare;

import com.oocl.handle_data.pojo.Customer;

import java.util.Comparator;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerIdComparator implements Comparator<Customer> {
    public int compare(Customer o1, Customer o2) {
        return o1.getId() - o2.getId();
    }
}
