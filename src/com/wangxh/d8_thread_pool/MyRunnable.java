package com.wangxh.d8_thread_pool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ "输出了...：" +i);
            try {
                System.out.println(Thread.currentThread().getName()+"本任务与线程绑定了，线程进入休眠了~~~");
                Thread.sleep(1000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
