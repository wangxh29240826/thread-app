package com.wangxh.d4_thread_code;

/**
 * 取钱的线程类
 */
public class DrawThread extends Thread{
    //接收处理的账户对象
    private Account acc;
    public DrawThread(Account acc, String name){
        super(name);
        this.acc = acc;}


    @Override
    public void run(){
        //两个人取钱
        acc.drawMoney(100000);
    }
}
