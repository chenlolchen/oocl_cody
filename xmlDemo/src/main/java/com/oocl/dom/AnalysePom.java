package com.oocl.dom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class AnalysePom {
    public static void main(String[] args) throws Exception {

        SAXBuilder builder = new SAXBuilder(true);
        builder.setFeature("http://apache.org/xml/features/validation/schema", true);
        builder.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "maven.xsd");
        Document document = builder.build(new FileInputStream("pom.xml"));
//        Document document = new SAXBuilder(false).build(new FileInputStream("pom.xml"));
        Element root = document.getRootElement();
        List<Element> list = root.getChildren();
        for (Element e : list){
//            e.getChild("dependencies");
            if(e.getName().equals("dependencies")){
                List<Element> dependencies = e.getChildren();
                for (Element element : dependencies){
                    List<Element> elementList = element.getChildren();
                    for (Element ee : elementList){
                        System.out.println(ee.getValue());
                    }
                }
            }
//            System.out.println(e.getText());
        }

    }
}
