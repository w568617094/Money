package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQRev_Main {
    public static void main(String[] args) throws JMSException {
        String url="tcp://39.104.170.153:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
        Connection connection =factory.createConnection();
        connection.start();
        Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue =session.createQueue("hello");
        MessageConsumer consumer=session.createConsumer(queue);
//       consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//
//                    try {
//                        if (message instanceof TextMessage) {
//                            System.out.println("文本消息" + ((TextMessage) message).getText());
//                        }else if (message instanceof ObjectMessage){
//                            System.out.println("对象消息"+((ObjectMessage) message).getObject());
//                        }
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//
//            }
//        });
        consumer.setMessageListener((message)-> {
            try {
                if (message instanceof TextMessage) {
                    System.err.println("文本消息：" + ((TextMessage) message).getText());
                }else if(message instanceof ObjectMessage){
                    System.err.println("对象消息："+((ObjectMessage)message).getObject());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
//        session.close();
//        connection.close();
    }
}
