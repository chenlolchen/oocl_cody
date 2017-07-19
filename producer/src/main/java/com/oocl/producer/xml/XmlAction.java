package com.oocl.producer.xml;

import com.oocl.producer.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public interface XmlAction {
    void createXmlData(int number);

    List<Book> readData();
}
