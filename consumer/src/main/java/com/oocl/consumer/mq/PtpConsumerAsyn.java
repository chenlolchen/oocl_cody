package com.oocl.consumer.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.consumer.dao.BookDao;
import com.oocl.consumer.dao.impl.BookDaoImpl;
import com.oocl.consumer.pojo.Book;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.json.JSONObject;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class PtpConsumerAsyn {
    private BookDao bookDao;

    public PtpConsumerAsyn(){
        this.bookDao = new BookDaoImpl();
    }

    public void start(){
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
                        List<Book> bookList = new ArrayList<Book>();
                        for(int i = 0; i < 100; i++){
                            ObjectMapper mapper = new ObjectMapper();
                            Book book = mapper.readValue(msg.getText(), Book.class);
                            bookList.add(book);
                        }
                        bookDao.batchAddBook(bookList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
