package com.wangxh.d4_thread_code;

public class Account {
    private String cardId;
    private double money;


    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    /**
     * 两个人取钱
     * @param money
     */

    public void drawMoney(double money) {
        //先获取是谁来取钱，线程的名字就是人名
        String name = Thread.currentThread().getName();
        synchronized (this){
            //1.判断账户是否够钱
            if (this.money>=money){
                //2.取钱
                System.out.println(name + "取钱成功，吐出" + this.money);
                //3.更新余额
                this.money -= money;
                System.out.println(name + "取钱后剩余" + this.money);
            }else{
                System.out.println(name+"您的余额不足");
            }
        }
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


}
