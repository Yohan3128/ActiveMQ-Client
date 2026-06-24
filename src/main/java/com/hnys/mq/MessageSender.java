package com.hnys.mq;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

public class MessageSender {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        connectionFactory.setBrokerURL("tcp://localhost:61616");

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("news");

            MessageProducer producer = session.createProducer(topic);

            TextMessage message = session.createTextMessage("Hello World");

            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, "* * * * *");

            producer.send(message);

            producer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
