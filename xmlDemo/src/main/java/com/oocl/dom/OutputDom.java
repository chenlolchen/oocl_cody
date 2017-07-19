package com.oocl.dom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class OutputDom {
    public static void main(String[] args) throws Exception {
        Element root = new Element("books");
        Document document = new Document();
        document.setRootElement(root);
        for(int i = 0; i < 10; i++){
            Element bookElement = new Element("book");
            bookElement.setAttribute("id","c" + i);
            Element nameElement = new Element("name");
            nameElement.setText("book" + i);
            Element priceElement = new Element("price");
            priceElement.setText((i + 3) + "元");
            bookElement.addContent(nameElement);
            bookElement.addContent(priceElement);
            root.addContent(bookElement);
        }

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        Writer writer = new FileWriter("books1.xml");
        xmlOutputter.output(document, writer);
        writer.close();
    }
}
