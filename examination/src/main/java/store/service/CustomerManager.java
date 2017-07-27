package store.service;


import store.pojo.Customer;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public interface CustomerManager {
    Customer loadCustomer(String name, String password);
}
