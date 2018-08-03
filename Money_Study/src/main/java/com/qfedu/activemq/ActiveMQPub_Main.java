package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class ActiveMQPub_Main {
    public static void main(String[] args) throws JMSException {
        String url="tcp://39.104.170.153:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
        Connection connection=factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("money");
        MessageProducer producer=session.createProducer(topic);
        producer.send(session.createObjectMessage(new Offer(101,"aaa","xxx",3000)));

    }
}
