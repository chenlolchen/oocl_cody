package com.oocl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////        Render r = (Render) context.getBean("pie");
////        r.render();
////
////        Render r2 = (Render) context.getBean("line");
////        r2.render();
//
////        Collector c1 = context.getBean(Collector.class);
//////        Collector c2 = context.getBean(Collector.class);
//////        System.out.println(c1 == c2);
////        NetCollector c11 = (NetCollector) c1;
////        System.out.println(c11.getCname());
//        Analyser analyser = context.getBean(Analyser.class);
//        analyser.analyse();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Render r = context.getBean(Render.class);
//        r.render();
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());

    }
}
