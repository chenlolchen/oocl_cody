package com.oocl.producer.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.producer.pojo.Book;
import com.oocl.producer.xml.XmlAction;
import com.oocl.producer.xml.impl.XmlActionImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.json.JSONObject;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class PtpProducer {
    private XmlAction xmlAction;

    public PtpProducer(){
        this.xmlAction = new XmlActionImpl();
    }

    public void start(){
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Destination queue = new ActiveMQQueue("chen_queue");
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            List<Book> bookList = xmlAction.readData();
            for (Book book : bookList){
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String str = mapper.writeValueAsString(book);
                    TextMessage message = session.createTextMessage(str.toString());
                    producer.send(message);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

            }

            System.out.println(connection);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
