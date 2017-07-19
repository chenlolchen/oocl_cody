package com.oocl.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class JacksonTest {
    public static void main(String[] args) throws IOException {
        Address a = new Address(2, "sss");
        Customer c = new Customer(1,"chen", new Date(),2.66, 20);
        c.setAddress(a);
        a.setCustomer(c);
        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new FileOutputStream("customer.json"), c);
        Customer customer = mapper.readValue(new FileInputStream("customer.json"), Customer.class);
        System.out.println(customer);
    }
}
