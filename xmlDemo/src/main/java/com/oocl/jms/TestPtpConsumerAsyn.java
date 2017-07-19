package com.oocl.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
// 异步
public class TestPtpConsumerAsyn {
    public static void main(final String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination queue = new ActiveMQQueue("chen_queue");
        Connection connection = factory.createConnection();
        connection.start();
//        Session.AUTO_ACKNOWLEDGE down 机的时候没办法
//        Session.CLIENT_ACKNOWLEDGE 解决 down 机问题
        final Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);

        final MessageConsumer consumer = session.createConsumer(queue);

//        consumer.setMessageListener(new MessageListener() {
//            public void onMessage(Message message) {
//                TextMessage msg = (TextMessage) message;
//                try {
//                    System.out.println(msg.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        System.out.println("main end ...");


        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        TextMessage message1 = (TextMessage) consumer.receive();
                        System.out.println(message1.getText());
//                        session.commit(); //数据提交
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        System.out.println("main end ...");





//        int m = 1 / 0;
//        TextMessage message2 = (TextMessage) consumer.receive();
//        System.out.println(message2.getText());

//        message.acknowledge();
//        session.commit();

//        consumer.close();
//        session.close();
//        connection.close();
    }
}
