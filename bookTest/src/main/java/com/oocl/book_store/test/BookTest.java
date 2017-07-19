package com.oocl.book_store.test;

import com.oocl.book_store.action.BookAction;
import com.oocl.book_store.action.impl.BookActionImpl;
import com.oocl.book_store.pojo.Book;
import com.oocl.book_store.util.DBUtil;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BookTest {
    public static void main(String[] args) {
        BookAction bookAction = new BookActionImpl();
        List<Book> bookList = bookAction.initData(10000);
        bookAction.saveDataToFile(bookList);
        List<Book> readData = bookAction.readData();
        bookAction.saveBatchDataToDB(readData);
    }
}
