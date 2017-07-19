package com.oocl.book_store.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class Producer {
    public void start(){
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            Destination destination = new ActiveMQQueue("chen_queue");
            Connection connection = factory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
