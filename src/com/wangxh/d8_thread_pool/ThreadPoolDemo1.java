package com.wangxh.d8_thread_pool;

import java.util.concurrent.*;

/**
 * 目标：自定义一个线程池对象，并测试其对象
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //1.创建线程池对象
        /**
         * public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         */
        ExecutorService pool = new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //2.给任务线程池处理
        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        //创建临时线程
        pool.execute(target);
        pool.execute(target);
        //不创建，拒绝策略被触发
        pool.execute(target);


        //关闭线程池（开发中一般不用）
        pool.shutdownNow();

    }

}
