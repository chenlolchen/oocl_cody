package shop_store.service.impl;

import shop_store.dao.OrderDao;
import shop_store.dao.impl.OrderDaoImpl;
import shop_store.pojo.Order;
import shop_store.service.OrderManager;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class OrderManagerImpl implements OrderManager {
    private OrderDao orderDao;

    public OrderManagerImpl(){
        orderDao = new OrderDaoImpl();
    }

    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }
}
