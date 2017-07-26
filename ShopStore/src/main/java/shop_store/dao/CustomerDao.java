package shop_store.dao;

import shop_store.pojo.Customer;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public interface CustomerDao {
    Customer loadUser(String name, String password);
}
