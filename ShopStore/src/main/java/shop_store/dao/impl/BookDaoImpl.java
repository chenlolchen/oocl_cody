package shop_store.dao.impl;

import shop_store.dao.BookDao;
import shop_store.pojo.Book;
import shop_store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class BookDaoImpl implements BookDao{

    public List<Book> findAllBooks() {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from books";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setImage(rs.getString("image"));
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }
}
