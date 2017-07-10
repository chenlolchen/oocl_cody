package com.oocl;

import java.util.Comparator;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class NameComparator implements Comparator<Customer> {
    public int compare(Customer o1, Customer o2) {
        return o1.name.compareTo(o2.name);
    }
}
