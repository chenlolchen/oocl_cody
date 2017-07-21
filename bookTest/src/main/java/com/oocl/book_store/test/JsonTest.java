package com.oocl.book_store.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.book_store.action.BookAction;
import com.oocl.book_store.action.impl.BookActionImpl;
import com.oocl.book_store.pojo.Book;
import com.oocl.book_store.util.JsonUtil;
import netscape.javascript.JSUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class JsonTest {
    public static void main(String[] args) throws IOException {
//        BookAction bookAction = new BookActionImpl();
//        List<Book> bookList = bookAction.initData(20);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new FileOutputStream("book.json"), bookList);
        Book book = new Book(2, "nn", new Date(), "aaa", 5.36, true, "ppp");
        String str = JsonUtil.toJsonString(book);
        System.out.println(str);
        Book b2 = (Book) JsonUtil.toJsonObject(str, Book.class);
        System.out.println(b2);
    }
}
