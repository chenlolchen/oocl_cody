package com.oocl.book_store.dao.impl;

import com.oocl.book_store.dao.BookDao;
import com.oocl.book_store.pojo.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BookDaoImplTest {

    private static BookDao bookDao;

    @BeforeClass
    public static void init(){
        bookDao = new BookDaoImpl();
    }

    @Test
    public void addBook() {
        Book b = new Book(null, "java", new Date(), "cody", 22.34, true, "sam");
        int m = bookDao.addBook(b);
        Assert.assertTrue(m == 1);
    }

//    @Test
//    public void deleteBook() {
//        int m = bookDao.deleteBook(4);
//        Assert.assertTrue(m == 1);
//    }

    @Test
    public void updateBook() {
        Book b = new Book(3, "php", new Date(), "sky", 55.75, false, "allen");
        int m = bookDao.updateBook(b);
        Assert.assertTrue(m == 1);
    }

    @Test
    public void loadBook() {
        Book b = bookDao.loadBook(6);
        System.out.println(b);
        Assert.assertTrue(b != null);
    }

    @Test
    public void findAll() {
        List<Book> bs = bookDao.findAll();
        for (Book b : bs){
            System.out.println(b);
        }
        Assert.assertTrue(!bs.isEmpty());
    }

}