package com.wangxh.d9_timer;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerDemo2 {
    public static void main(String[] args) {
        //1.创建ScheduledExecutorService线程池做定时器
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        //2.开启定时任务
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "实行输出：AAA" + new Date());
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "实行输出：BBB" + new Date());
                System.out.println(10/0);
            }
        },0,2, TimeUnit.SECONDS);
    }
    }

