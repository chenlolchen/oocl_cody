package com.oocl.producer.xml;


import com.oocl.producer.pojo.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            book.setId(Integer.valueOf(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("element  " + qName + "  end...");
        if(qName.equals("book")){
//            System.out.println(book);
            bookList.add(book);
        }else if(qName.equals("name")){
            book.setName(text);
        }else if(qName.equals("publishDate")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = format.parse(text);
                book.setPublishDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if(qName.equals("author")){
            book.setAuthor(text);
        }else if(qName.equals("price")){
            book.setPrice(Double.valueOf(text));
        }else if(qName.equals("newBook")){
            book.setNewBook(Boolean.parseBoolean(text));
        }else if(qName.equals("publisher")){
            book.setPublisher(text);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = new String(ch, start, length);
    }

    public List<Book> getBookList(){
        return this.bookList;
    }
}
