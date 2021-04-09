package com.threadlocal;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/3/24 17:01
 * @Version V1.0
 **/
public class DefaultThreadPool<Job extends Runnable> implements TheadPool {

    //最大线程数
    private static final int MaxWorkerNumber=10;
    //默认线程数
    private static final int DefaultWorkerNumber=5;
    //最小线程数
    private static final int MinWorkerNumber=1;

    //这是一个任务队列，将会向里面插入任务
    private final LinkedList<Job> jobs=new LinkedList<Job>();
    //工作列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程数量
    private int workerNum=DefaultWorkerNumber;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();
    public DefaultThreadPool(){
        initializeWorker(DefaultWorkerNumber);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MaxWorkerNumber?MaxWorkerNumber:num<MinWorkerNumber?MinWorkerNumber:num;
        initializeWorker(workerNum);
    }

    //初始化工作者
    private void initializeWorker(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            System.out.println("添加工作者线程：ThreadPool-Worker-" + threadNum.get());
            thread.start();
        }


    }


    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutDown() {

    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }


    //工作者线程消费任务
     class Worker implements Runnable{
        //是否工作
        private volatile boolean running=true;
        @Override
        public void run() {
            while(true){
                Job job=null;
                synchronized(jobs){
                    //如果任务队列是空的，那么就wait
                    while(jobs.isEmpty()){
                        if(running==false){
                            System.out.println(Thread.currentThread().getName()+"结束");
                            return;
                        }
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if(running==false){
                        System.out.println(Thread.currentThread().getName()+"结束");
                        return;
                    }
                    //取出一个Job
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    try{
                        System.out.println(Thread.currentThread().getName()+" 执行任务 "+job.toString());
                        job.run();
                    }catch(Exception e){
                        //忽略Job执行中的Exception
                    }
                }
            }

        }
        //关闭当前工作者
        public void shutdown(){
            running=false;
            System.err.println("关闭一个工作者线程");
        }
    }
}





