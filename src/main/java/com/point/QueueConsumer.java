package com.point;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/8 17:09
 * @Version V1.0
 **/
@Component
public class QueueConsumer {

    Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    @JmsListener(destination = "my.queue")
    public void receiveQueue1(String text){
        logger.info("消费者1收到的报文为:" + text);
    }

    @JmsListener(destination = "my.queue")
    public void receiveQueue2(String text){
        logger.info("消费者2收到的报文为:" + text);
    }
}
