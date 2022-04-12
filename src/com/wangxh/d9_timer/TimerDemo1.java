package com.wangxh.d9_timer;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
    public static void main(String[] args) {
        //定义定时器  定时器本身结束一个单线程
        Timer timer = new Timer();
        //2.调用方法，处理定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+ "执行AAA~~" + new Date());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName()+ "执行AAA~~" + new Date());
                }
        },0,2000);
    }

}
