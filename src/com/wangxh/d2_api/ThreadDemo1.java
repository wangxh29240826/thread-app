package com.wangxh.d2_api;


/**
 * 线程APi
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("一号");
//        t1.setName("1号");
        t1.start();
        System.out.println(t1.getName());


        Thread t2 = new MyThread("2号");
//        t2.setName("2号");
        t2.start();
        System.out.println(t2.getName());


        //那个线程执行它它就得到哪个线程对象
        //主线程名称就叫main
        Thread m = Thread.currentThread();
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("main线程输出：" + i);
        }

    }
}
