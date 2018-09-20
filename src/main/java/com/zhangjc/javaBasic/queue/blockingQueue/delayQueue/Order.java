package com.zhangjc.javaBasic.queue.blockingQueue.delayQueue;

/**
 * 订单信息类
 * Created by user on 2018/9/20.
 */
public class Order {
    private String name;
    private int price;

    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
