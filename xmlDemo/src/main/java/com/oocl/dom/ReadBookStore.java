package com.oocl.dom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class ReadBookStore {
    public static void main(String[] args) throws Exception {
        Document document = new SAXBuilder(false).build(new FileInputStream("books.xml"));
        Element root = document.getRootElement();
        System.out.println(root.getName());
        List<Element> list = root.getChildren();
        for(Element e : list){
            Book book = new Book();
            book.setAuthor(e.getChild("author").getTextTrim());
            book.setIsbn(e.getAttributeValue("ISBN"));
            book.setType(e.getAttributeValue("Type"));
            book.setTitle(e.getChild("title").getTextTrim());
            book.setPrice(e.getChild("price").getTextTrim());
            System.out.println(book);
        }
    }
}
