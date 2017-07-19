package com.oocl.consumer.dao;


import com.oocl.consumer.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public interface BookDao {
    int addBook(Book book);
    int deleteBook(Integer id);
    int updateBook(Book book);
    Book loadBook(Integer id);
    List<Book> findAll();
    int batchAddBook(List<Book> readData);
}
