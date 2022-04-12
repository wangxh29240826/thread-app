package com.wangxh.d2_api;

/**
 * 线程api
 *
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws Exception{
        for (int i = 1; i <= 100; i++) {
            System.out.println("输出：" + i);
            if (i == 3){
                //让当前线程进入休眠状态
                Thread.sleep(3000); //单位为毫秒
            }
        }
    }
}
