package com.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/9 11:57
 * @Version V1.0
 **/
@Component
public class TopicSub {

    Logger logger = LoggerFactory.getLogger(TopicSub.class);

    @JmsListener(destination = "sub.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive1(String text) {
        logger.info("video.topic 消费者:receive1=" + text);
    }

    @JmsListener(destination = "sub.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive2(String text) {
        logger.info("video.topic 消费者:receive2=" + text);
    }

    @JmsListener(destination = "sub.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive3(String text) {
        logger.info("video.topic 消费者:receive3=" + text);
    }

}
