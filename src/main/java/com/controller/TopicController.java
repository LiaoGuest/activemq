package com.controller;

import com.service.topic.ProducerTopicService;
import com.service.topic.impl.ProducerTopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/9 11:54
 * @Version V1.0
 **/
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ProducerTopicService producerTopicService;

    @RequestMapping("/{msg}")
    public String sendTopic(@PathVariable String msg){
        producerTopicService.publish(msg);
        return msg+"发送成功";
    }
}
