package com.oocl.jdbc.dao.impl;

import com.oocl.jdbc.dao.CustomerDao;
import com.oocl.jdbc.pojo.Customer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 * 不断根据测试用例加东西
 * 好的测试是先清空数据库
 * 然后再跑代码
 */
public class CustomerDaoImplTest {
    private static CustomerDao customerDao;

    @BeforeClass
    public static void init(){
        customerDao = new CustomerDaoImpl();
    }

    @Test
    public void addCustomer() {
        Customer c = new Customer(null, "chen", true, 34.25, new Date());
        int m = customerDao.addCustomer(c);
        Assert.assertTrue(m == 1);
    }

//    @Test
//    public void deleteCustomer() {
//        int m = customerDao.deleteCustomer(5);
//        Assert.assertTrue(m == 1);
//    }

    @Test
    public void updateCustomer() {
        Customer c = new Customer(4, "chen22", false, 34.25, new Date());
        int m = customerDao.updateCustomer(c);
        Assert.assertTrue(m == 1);
    }

    @Test
    public void loadCustomer() {
        Customer c = customerDao.loadCustomer(4);
        Customer c1 = customerDao.loadCustomer(5);
        System.out.println(c);
        Assert.assertTrue(c != null);
        Assert.assertTrue(c1 == null);
    }

    @Test
    public void findAll() {
        List<Customer> cs = customerDao.findAll();
        for (Customer c : cs){
            System.out.println(c);
        }
        Assert.assertTrue(!cs.isEmpty());
    }

}