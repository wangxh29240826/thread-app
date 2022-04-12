package com.wangxh.d7_thread_comunication;

/**
 * 目标：模拟线程通信，来点提醒线程，接电话线程
 */
public class Phone {
    //实现线程间通信：默认认为手机当当前处于等待来电提醒
    private boolean flag = false;

    public void run(){
        //a,负责来电提醒
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   while (true) {
                       synchronized (Phone.this){
                           if (!flag){
                               //代表要来点提醒了
                               System.out.println("您好，有新电话呼入，请接听~~");
                               Thread.sleep(Long.parseLong(("5000")));
                               flag = true;

                               Phone.this.notify();
                               Phone.this.wait();
                           }
                       }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();

       //b,接电话线程，正是接听了
        new Thread(new Runnable() {
            @Override
            public void run() {
                //不断的接听电话了
                try {
                    while (true){
                        synchronized (Phone.this){
                            if (flag){
                            //可以接听电话了
                            System.out.println("电话接听中，通信5分钟结束了~~");
                                Thread.sleep(Long.parseLong(("5000")));

                                flag = false;//代表要继续等待呼入电话
                                //唤醒别人,等待自己
                                Phone.this.notify();
                                Phone.this.wait();
                        }else {
                                Phone.this.notify();
                                Phone.this.wait();
                            }
                    }
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        //1.创建一部手机对象
        Phone iqqo = new Phone();
        iqqo.run();
    }
}
