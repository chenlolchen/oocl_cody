package com.oocl.handle_data.service.impl;

import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.service.CustomerService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;


/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerServiceImplTest {
    private static CustomerService customerService;


    @BeforeClass
    public static void init(){
        customerService = new CustomerServiceImpl();
    }

    @Test
    public void outputBySortId() throws Exception {
        Set<Customer> set = customerService.outputBySortId();
    }

    @Test
    public void outputBySortDate() throws Exception {
        Set<Customer> set = customerService.outputBySortDate();
    }

    @Test
    public void insertData() throws Exception {
        customerService.insertData("2 tom tom@163.com true 2000-9-3");
    }

}