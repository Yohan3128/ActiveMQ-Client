package com.hnys.mq;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        connectionFactory.setBrokerURL("tcp://localhost:61616");

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("news");

            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println("Received message: " + message.getBody(String.class));
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            while (true) {}
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
