package dao;

import pojo.Customer;

import java.util.List;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
public interface CustomerDao {
    Customer addCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer updateCustomer(Customer customer);

    String deleteCustomerById(String id);

    Customer loadCustomerById(String id);
}
