package shop_store.service.impl;


import shop_store.dao.CustomerDao;
import shop_store.dao.impl.CustomerDaoImpl;
import shop_store.pojo.Customer;
import shop_store.service.CustomerManager;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class CustomerManagerImpl implements CustomerManager {
    private CustomerDao customerDao;

    public CustomerManagerImpl() {
        this.customerDao = new CustomerDaoImpl();
    }

    public Customer loadCustomer(String name, String password) {
        return customerDao.loadUser(name, password);
    }
}
