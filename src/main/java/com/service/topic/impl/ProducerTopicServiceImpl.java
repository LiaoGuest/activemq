package com.service.topic.impl;

import com.service.topic.ProducerTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/9 11:15
 * @Version V1.0
 **/
@Service
public class ProducerTopicServiceImpl implements ProducerTopicService {

    Logger logger = LoggerFactory.getLogger(ProducerTopicServiceImpl.class);

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.topic, msg);
    }
}
