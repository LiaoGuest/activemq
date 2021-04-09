package com.topic.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/2 14:52
 * @Version V1.0
 **/
public class TopicConsumer {
    public static void main(String[] args) throws JMSException, IOException {
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
        //6.创建消息消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        //7.监听消息
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                System.out.println("消费111-接收到消息"+textMessage);
            }
        });
        //8.等待键盘输入
        System.in.read();
        //9.关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
