package com.zhangjc.javaBasic.queue.blockingQueue.delayQueue;/**
 * Created by user on 2018/9/20.
 */


import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @ClassName PutOrder
 * @Description 将订单放入定时队列中
 * @Autor user
 * @Date 2018/9/20 16:25
 * @Version 1.0
 **/
public class PutOrder implements Runnable{

    private DelayQueue<PackOrder<Order>> delayQueue;

    public PutOrder(DelayQueue<PackOrder<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        Random rr = new Random();
        Order order1 = new Order("zzz",rr.nextInt(100));
        //订单1有效期为5s
        PackOrder<Order> packOrder1 = new PackOrder<>(5000,order1);
        Boolean c =  delayQueue.offer(packOrder1);
        System.out.println("是否成功保存 " + c);
        System.out.println("订单5秒后过期 " + order1.getName());


        Order order2 = new Order("jjj",rr.nextInt(100));
        //订单1有效期为5s
        PackOrder<Order> packOrder2 = new PackOrder<>(8000,order1);
        Boolean b = delayQueue.offer(packOrder2);
        System.out.println("是否成功保存 " + b);
        System.out.println("订单8秒后过期 " + order1.getName());
    }
}
