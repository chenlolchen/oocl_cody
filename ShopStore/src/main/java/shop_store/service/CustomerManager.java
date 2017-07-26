package shop_store.service;


import shop_store.pojo.Customer;

import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public interface CustomerManager {
    Customer loadCustomer(String name, String password);
}
