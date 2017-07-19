package com.oocl.sax;

import com.oocl.dom.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class BooksHandler extends DefaultHandler {
    private Book book;
    private String text;
    private List<Book> bookList;

    @Override
    public void startDocument() throws SAXException {
        bookList = new ArrayList<Book>();
//        System.out.println("start ...");
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.println("end ...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("element  " + qName + "  start...");
        if(qName.equals("book")){
            book = new Book();
            book.setIsbn(attributes.getValue("ISBN"));
            book.setType(attributes.getValue("Type"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("element  " + qName + "  end...");
        if(qName.equals("book")){
//            System.out.println(book);
            bookList.add(book);
        }else if(qName.equals("title")){
            book.setTitle(text);
        }else if(qName.equals("author")){
            book.setAuthor(text);
        }else if(qName.equals("price")){
            book.setPrice(text);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = new String(ch, start, length);
//        System.out.println("name  " + new String(ch, start, length));
    }

    public List<Book> getBookList(){
        return this.bookList;
    }
}
