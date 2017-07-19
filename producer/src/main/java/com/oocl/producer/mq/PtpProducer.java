package com.oocl.producer.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.producer.pojo.Book;
import com.oocl.producer.xml.XmlAction;
import com.oocl.producer.xml.impl.XmlActionImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class PtpProducer implements Runnable {
    private int start;
    private int end;
    private List<Book> list;

    public PtpProducer(int start, int end, List<Book> list){
        this.list = list;
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Destination queue = new ActiveMQQueue("chen_queue");
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            for(int i = start; i < end; i++){
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String str = mapper.writeValueAsString(list.get(i));
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
