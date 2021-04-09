package com.service.point;

import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/7 9:32
 * @Version V1.0
 **/

public interface ProducerService {

    public void sendMessage(Destination destination, String message);
}
