package com.threadlocal;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/3/24 17:38
 * @Version V1.0
 **/
public class Worker implements Runnable{
    //是否工作
    private volatile boolean running = true;


    @Override
    public void run() {
        while (true){
            BatchProperties.Job job = null;
            synchronized (job){

            }
        }
    }
}
