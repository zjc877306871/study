package com.zhangjc.javaBasic.queue.blockingQueue.delayQueue;/**
 * Created by user on 2018/9/20.
 */

import java.util.concurrent.DelayQueue;

/**
 * @ClassName TakeOrder
 * @Description TODO
 * @Autor user
 * @Date 2018/9/20 16:44
 * @Version 1.0
 **/
public class TakeOrder implements Runnable{
    private DelayQueue<PackOrder<Order>> delayQueue;

    public TakeOrder(DelayQueue<PackOrder<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("999");
            System.out.println("size" + delayQueue.size());
            try {
                PackOrder<Order> order = delayQueue.take();
                System.out.println("获取的订单名字 " + order.getDate().getName());
            } catch (InterruptedException e) {
                System.out.println("出现异常");
                e.printStackTrace();
            }
        }

    }
}
