package com.oocl.dom;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
        List<Book> bookList = new ArrayList<Book>();
        for(Element e : list){
            Book book = new Book();
            book.setAuthor(e.getChild("author").getTextTrim());
            book.setIsbn(e.getAttributeValue("ISBN"));
            book.setType(e.getAttributeValue("Type"));
            book.setTitle(e.getChild("title").getTextTrim());
            book.setPrice(e.getChild("price").getTextTrim());
            bookList.add(book);
        }
        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new FileOutputStream("book.json"), bookList);

        List readList = mapper.readValue(new FileInputStream("book.json"), List.class);
        for (int i = 0; i < readList.size(); i++){
            System.out.println(readList.get(i));
        }
    }
}
