package com.threadlocal;

/**
 * @Description
 * @Author liuheng
 * @Date 2021/3/24 16:59
 * @Version V1.0
 **/
public interface TheadPool<Job extends Runnable> {
    //执行一个Job，这个Job需要实现Runnable接口
    void execute(Job job);
    //关闭线程池
    void shutDown();
    //增加工作者线程
    void addWorkers(int num);
    //减少工作者线程
    void removeWorker(int num);
    //得到正在等待执行的任务数量
    int getJobSize();

}
