package com.queue.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/1 16:21
 * @Version V1.0
 **/
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException{
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();

        //启动线程
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        //执行10秒
        Thread.sleep(10*100);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        
        Thread.sleep(2000);
        service.shutdown();
    }
}

