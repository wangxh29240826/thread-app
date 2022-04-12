package com.wangxh.d1_create;

/**
 * 目标：学会线程的创建方式二（匿名内部类方式实现，语法形式）
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //3.创建一个对象
        Runnable target = new  Runnable(){
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程执行输出：" + i);
                }
            }
        };


        //4.把任务对象交给Thread处理
        Thread t = new Thread(target);

        //5.启动线程
        t.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
}
