package store.service.impl;


import store.dao.CustomerDao;
import store.dao.impl.CustomerDaoImpl;
import store.pojo.Customer;
import store.service.CustomerManager;

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
