package com.oocl.book_store.dao;

import com.oocl.book_store.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public interface BookDao {
    void createSession();
    void closeSession();
    int addBookWithOutCloseSession(Book book);
    int addBook(Book book);
    int deleteBook(Integer id);
    int updateBook(Book book);
    Book loadBook(Integer id);
    List<Book> findAll();
    int batchAddBook(List<Book> readData);
}
