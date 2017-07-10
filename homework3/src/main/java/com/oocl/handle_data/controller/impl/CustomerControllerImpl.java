package com.oocl.handle_data.controller.impl;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.service.CustomerService;
import com.oocl.handle_data.service.impl.CustomerServiceImpl;
import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.util.FormatUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerControllerImpl implements CustomerController {
    CustomerService customerService;

    public CustomerControllerImpl(){
        customerService = new CustomerServiceImpl();
    }

    public void scanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("data.txt"));
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            customerService.insertData(s);
        }
    }

    public void outputBySortId() {
        Set<Customer> set = customerService.outputBySortId();
        for(Customer customer : set){
            System.out.println(customer);
        }
    }

    public void outputBySortDate() {
        Set<Customer> set = customerService.outputBySortDate();
        for(Customer customer : set){
            System.out.println(customer);
        }
    }

    public void outputXml() {
        Set<Customer> set = customerService.outputBySortId();
        FormatUtil.formatXml(set);
    }
}
