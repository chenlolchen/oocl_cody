package com.oocl.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class MyDefaultHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("doc start ...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("doc end ...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("element" + qName + "start ...");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("element" + qName + "end ...");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("char..." + new String(ch, start, length));
    }
}
