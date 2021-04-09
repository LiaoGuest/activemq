package com.topic.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Description  Pub/Sub发布订阅（广播）：使用topic作为通信载体   生产者
 * @Author liuheng
 * @Date 2021/4/2 14:47
 * @Version V1.0
 **/
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2.获取连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.获取session  (参数1：是否启动事务,参数2：消息确认模式)
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //5.创建主题对象
        Topic topic = session.createTopic("test-topic");
        //6.创建消息生产者
        MessageProducer messageProducer = session.createProducer(topic);
        //7.创建消息
        TextMessage textMessage = session.createTextMessage();
        //8.发送消息
        messageProducer.send(textMessage);
        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();


    }
}
