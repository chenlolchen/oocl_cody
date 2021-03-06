package com.oocl.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class TestPubProducer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination topic = new ActiveMQTopic("chen_topic");
        Connection connection = factory.createConnection();
        connection.start();
        // 没有使用事务
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 使用事务
//        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        MessageProducer producer = session.createProducer(topic);
        TextMessage message = session.createTextMessage("hello I am cody");
//        TextMessage message2 = session.createTextMessage("hello I am cody 2222");
        producer.send(message);

//        producer.send(message2);
//        session.commit();

        System.out.println(connection);
        producer.close();
        session.close();
        connection.close();
    }
}
