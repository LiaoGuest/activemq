package com.controller;

import com.service.point.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/7 9:35
 * @Version V1.0
 **/
@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private Queue queue;

    @RequestMapping("/{msg}")
    public String sendQueue(@PathVariable String msg){

        producerService.sendMessage(queue,msg);
        return msg+"发送成功";
    }
}
