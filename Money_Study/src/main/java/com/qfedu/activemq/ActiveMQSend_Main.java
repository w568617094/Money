package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQSend_Main {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.170.153:61616";
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
        Connection connection=factory.createConnection();
        connection.start();
        Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("hello");
        MessageProducer producer = session.createProducer(queue);
        ObjectMessage objectMessage =session.createObjectMessage(new Offer(1,"abc","cba",3000));
        producer.send(objectMessage);
//        session.close();
//        connection.close();

    }
}
