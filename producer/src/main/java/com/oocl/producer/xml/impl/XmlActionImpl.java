package com.oocl.producer.xml.impl;

import com.oocl.producer.pojo.Book;
import com.oocl.producer.xml.BooksHandler;
import com.oocl.producer.xml.XmlAction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class XmlActionImpl implements XmlAction{
    public XmlActionImpl(){

    }

    public void createXmlData(int number) {
        Element root = new Element("books");
        Document document = new Document();
        document.setRootElement(root);
        for(int i = 0; i < number; i++){
            Element bookElement = new Element("book");
            bookElement.setAttribute("id",i + "");
            Element nameElement = new Element("name");
            nameElement.setText("book" + i);
            Element dateElement = new Element("publishDate");
            dateElement.setText("2016-09-07");
            Element authorElement = new Element("author");
            authorElement.setText("cody");
            Element priceElement = new Element("price");
            priceElement.setText((i + 3) + "");
            Element newBookElement = new Element("newBook");
            newBookElement.setText("true");
            Element publisherElement = new Element("publisher");
            publisherElement.setText("chen");

            bookElement.addContent(nameElement);
            bookElement.addContent(dateElement);
            bookElement.addContent(authorElement);
            bookElement.addContent(priceElement);
            bookElement.addContent(newBookElement);
            bookElement.addContent(publisherElement);

            root.addContent(bookElement);
        }

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        Writer writer = null;
        try {
            writer = new FileWriter("books.xml");
            xmlOutputter.output(document, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> readData() {
        SAXParser parser = null;
        List<Book> bookList = null;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
            //向事件源注册handler
            BooksHandler booksHandler = new BooksHandler();
            parser.parse("books.xml", booksHandler);
            bookList = booksHandler.getBookList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
