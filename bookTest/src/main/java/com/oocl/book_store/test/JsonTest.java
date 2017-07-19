package com.oocl.book_store.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.book_store.action.BookAction;
import com.oocl.book_store.action.impl.BookActionImpl;
import com.oocl.book_store.pojo.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class JsonTest {
    public static void main(String[] args) throws IOException {
        BookAction bookAction = new BookActionImpl();
        List<Book> bookList = bookAction.initData(10);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileOutputStream("book.json"), bookList);
    }
}
