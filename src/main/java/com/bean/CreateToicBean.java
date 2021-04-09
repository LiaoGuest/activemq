package com.bean;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/9 11:06
 * @Version V1.0
 **/
@Component
public class CreateToicBean {

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("sub.topic");
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        bean.setPubSubDomain(true);
        return bean;
    }
}
