package com.oocl.book_store.thread;

import com.oocl.book_store.dao.BookDao;
import com.oocl.book_store.dao.impl.BookDaoImpl;
import com.oocl.book_store.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class DBWriteThread implements Runnable {
    private List<Book> bookList;
    private BookDao bookDao;
    private int start;
    private int end;

    public DBWriteThread(int start, int end, List<Book> bookList){
        this.bookList = bookList;
        this.bookDao = new BookDaoImpl();
        this.start = start;
        this.end = end;
    }

    public void run() {
        bookDao.createSession();
        for(int i = start; i < end; i++){
            bookDao.addBookWithOutCloseSession(bookList.get(i));
        }
        bookDao.closeSession();
    }
}
