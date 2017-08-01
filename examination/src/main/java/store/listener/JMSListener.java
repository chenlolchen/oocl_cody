package store.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
@WebListener
public class JMSListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Destination queue = new ActiveMQQueue("chen_queue");
            Connection connection = factory.createConnection();
            connection.start();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            final MessageConsumer consumer = session.createConsumer(queue);

            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage msg = (TextMessage) message;
                    try {
                        System.out.println("aa");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
