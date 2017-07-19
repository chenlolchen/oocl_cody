package com.oocl.sax;

import com.oocl.dom.Book;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class BookSaxTest {
    public static void main(String[] args) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //向事件源注册handler
        BooksHandler booksHandler = new BooksHandler();
        parser.parse("books.xml", booksHandler);
        List<Book> bookList = booksHandler.getBookList();
        for (Book book : bookList){
            System.out.println(book);
        }
    }
}
