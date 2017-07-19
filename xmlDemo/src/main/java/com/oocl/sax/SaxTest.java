package com.oocl.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class SaxTest {
    public static void main(String[] args) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //向事件源注册handler
        parser.parse("books1.xml", new MyDefaultHandler());
    }
}
