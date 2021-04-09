package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description        启动主函数访问http://localhost:8081/queue/XXX就可以往队列中添加数据
 * @Author liuheng
 * @Date 2021/4/7 9:41
 * @Version V1.0
 **/
@SpringBootApplication
public class MqApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
        System.out.println("mq service start success!");
    }
}
