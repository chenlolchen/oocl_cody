package shop_store.dao.impl;

import shop_store.dao.OrderDao;
import shop_store.pojo.Order;
import shop_store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class OrderDaoImpl implements OrderDao{

    public int addOrder(Order order) {
        String sql = "insert into orders(id, customer_id, book_id, created_date, amount) values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getId());
            preparedStatement.setString(2, order.getCustomerId());
            preparedStatement.setString(3, order.getBookId());
            preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
            preparedStatement.setInt(5, order.getAmount());
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }
}
