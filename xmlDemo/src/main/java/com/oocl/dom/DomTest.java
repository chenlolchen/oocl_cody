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
public class DomTest {
    public static void main(String[] args) throws Exception {
//        Document document = null;
//        document.getElementById("id");
//        document.getElementsByTagName("name");

        Document document = new SAXBuilder(false).build(new FileInputStream("customers.xml"));
        Element root = document.getRootElement();
        System.out.println(root.getName());
        List<Element> list = root.getChildren();
        for(Element e : list){
            String id = e.getAttribute("id").getValue();
            System.out.println(id);
            String name = e.getChild("name").getTextTrim();
            System.out.println(name);
            String age = e.getChild("age").getTextTrim();
            System.out.println(age);
        }
    }
}
