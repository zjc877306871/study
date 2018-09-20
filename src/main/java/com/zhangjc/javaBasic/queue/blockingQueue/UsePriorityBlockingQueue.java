package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;
import com.zhangjc.javaBasic.queue.entry.People;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 一个支持优先级排序的无界阻塞队列。
 * 默认情况下，按照自然顺序，要么实现compareTo()方法，指定构造参数Comparator
 * Created by user on 2018/9/20.
 */
public class UsePriorityBlockingQueue {
    public static void main(String[] args) {
        PriorityBlockingQueue<People> priorityBlockingQueue = new PriorityBlockingQueue<>();

        String monthName1 = "put";
        String monthName2 = "take";
        ProductThread productThread = new ProductThread(priorityBlockingQueue,monthName1);
        ConsumerThread consumerThread = new ConsumerThread(priorityBlockingQueue,monthName2);

        for(int i = 0; i < 3; i++){
            new Thread(productThread).start();
        }

        ThreadSleepTools.sleepSeconds(1);
        for(int i = 0; i < 5; i++){
            new Thread(consumerThread).start();
        }
    }


}
