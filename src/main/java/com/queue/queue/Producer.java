package com.queue.queue;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/4/1 15:59
 * @Version V1.0
 **/
public class Producer implements Runnable{

    private BlockingQueue queue;
    private volatile boolean isRunning = true;
    private static AtomicInteger count = new AtomicInteger();
    private static final int DEFAULT_SLEEP=1000;

    public Producer(BlockingQueue queue){
        this.queue=queue;
    }


    @Override
    public void run() {
        String data = "";
        System.out.println("启动生产者线程！！");

        Random random = new Random();

        try{
            while (isRunning){
                System.out.println("正在生产数据。。");
                Thread.sleep(random.nextInt(DEFAULT_SLEEP));
                data = "data:"+count.incrementAndGet();
                System.out.println("将队列{"+data+"}放入队列");
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("放入数据失败"+data);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("退出生产者线程");
        }
    }

    public void stop(){
        isRunning = false;
    }
}
