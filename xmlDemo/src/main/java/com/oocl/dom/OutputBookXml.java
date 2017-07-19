package com.oocl.dom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class OutputBookXml {
    public static void main(String[] args) throws IOException {
        Element bookstore = new Element("bookstore");
        Document document = new Document();
        document.setRootElement(bookstore);
        String[] titleList = {"数据结构", "路由型与交换型互联网基础", "计算机硬件技术基础", "软件质量保证与管理"};
        int increment = 2;

        for(int i = 0; i < 6; i++){
            Element bookElement = new Element("book");
            bookElement.setAttribute("TyPe","必修课");
            bookElement.setAttribute("ISbN","7-111-19149-" + (increment++));
            Element titleElement = new Element("title");
            titleElement.setText("数据结构");
            Element authorElement = new Element("author");
            authorElement.setText("严蔚敏");
            Element priceElement = new Element("price");
            priceElement.setText("30.00");

            bookElement.addContent(titleElement);
            bookElement.addContent(authorElement);
            bookElement.addContent(priceElement);

            bookstore.addContent(bookElement);
        }

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        Writer writer = new FileWriter("copy.xml");
        xmlOutputter.output(document, writer);
        writer.close();

    }
}
