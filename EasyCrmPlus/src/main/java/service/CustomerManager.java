package service;

import pojo.Customer;

import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public interface CustomerManager {
    int addCustomer(Customer customer);

    List<Customer> findAllCustomers();

    List<String> getFavsById(int id);

    int delCustomerById(int id);

    Customer loadCustomer(int id);

    int updateCustomer(Customer customer);
}
