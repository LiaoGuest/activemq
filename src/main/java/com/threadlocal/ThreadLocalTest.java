package com.threadlocal;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/3/24 17:37
 * @Version V1.0
 **/
public class ThreadLocalTest {

    //创建一个Integer型的线程本地变量
    private static final ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    static class Counter implements Runnable{


        @Override
        public void run() {
            //获取当前线程池的本地变量，然后累加5次
            int num = local.get();
            for (int i=0;i<num;i++){
                num++;
            }
            //重新设置累加后的本地变量
            local.set(num);
            System.out.println(Thread.currentThread().getName() + " : "+ local.get());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Counter() ,"CounterThread-[" + i+"]");
            threads[i].start();
        }
    }



}
