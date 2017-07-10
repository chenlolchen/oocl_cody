package com.oocl.test;

import com.oocl.Address;
import com.oocl.Customer;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.id = 20;
        customer.age = 33;
        Address address = new Address();
        address.city = 11;
        customer.address = address;

        Customer customer1 = (Customer) customer.clone();
        customer1.id = 555;
        //浅克隆
        customer1.address.city = 6789;
        System.out.println(customer1.id);
        System.out.println(customer.address.city);
    }
}
