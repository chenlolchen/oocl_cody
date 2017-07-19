package com.oocl.book_store.dao.impl;

import com.oocl.book_store.dao.BookDao;
import com.oocl.book_store.pojo.Book;
import com.oocl.book_store.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BookDaoImpl implements BookDao {
    private Connection connection;

    public void createSession(){
        this.connection = DBUtil.createConnectionWithDataSource();
    }

    public void closeSession(){
        DBUtil.close(this.connection, null, null);
    }

    public int addBookWithOutCloseSession(Book book){
        String sql = "INSERT INTO books(id, name, pub_date, author, price, is_new, publisher) VALUES (seq01.nextval,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        int m = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, new java.sql.Date(book.getPublishDate().getTime()));
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setBoolean(5, book.isNewBook());
            preparedStatement.setString(6, book.getPublisher());
            m = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public int addBook(Book book) {
        String sql = "INSERT INTO books(id, name, pub_date, author, price, is_new, publisher) VALUES (seq01.nextval,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, new java.sql.Date(book.getPublishDate().getTime()));
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setBoolean(5, book.isNewBook());
            preparedStatement.setString(6, book.getPublisher());
            m = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public int deleteBook(Integer id) {
        String sql = "delete books where id = ?";
        int m = 0;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            m = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }

        return m;
    }

    public int updateBook(Book book) {
        String sql = "update books set name = ?, pub_date = ?, author = ?, price = ?, is_new = ?, publisher = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, new Date(book.getPublishDate().getTime()));
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setBoolean(5, book.isNewBook());
            preparedStatement.setString(6, book.getPublisher());
            preparedStatement.setInt(7, book.getId());
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public Book loadBook(Integer id) {
        String sql = "select * from books where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Book book = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPublishDate(rs.getDate("pub_date"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setNewBook(rs.getBoolean("is_new"));
                book.setPublisher(rs.getString("publisher"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return book;
    }

    public List<Book> findAll() {
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
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPublishDate(rs.getDate("pub_date"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setNewBook(rs.getBoolean("is_new"));
                book.setPublisher(rs.getString("publisher"));
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }

    public int batchAddBook(List<Book> list) {
        String sql = "INSERT INTO books(id, name, pub_date, author, price, is_new, publisher) VALUES(seq01.nextval,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        Connection conn = null;
        int result = 0;
        try {
            conn = DBUtil.createConnectionWithDataSource();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                Book b = list.get(i);
                pst.setString(1, b.getName());
                pst.setDate(2, new java.sql.Date(b.getPublishDate().getTime()));
                pst.setString(3, b.getAuthor());
                pst.setDouble(4, b.getPrice());
                pst.setBoolean(5, b.isNewBook());
                pst.setString(6, b.getPublisher());
                pst.addBatch();
            }
            result = pst.executeBatch().length;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, null);
        }
        return result;
    }
}
