package com.service.point.impl;

import com.service.point.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/7 9:31
 * @Version V1.0
 **/
@Service
public class ProducerServiceImpl implements ProducerService {

    Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(Destination destination, String message) {
        logger.info("准备发送消息的是:" + message);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
