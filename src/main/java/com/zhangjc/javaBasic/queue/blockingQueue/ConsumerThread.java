package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 模拟消费者进行消费队列信息
 * Created by user on 2018/9/19.
 */
public class ConsumerThread implements Runnable{
    BlockingQueue queue ;

    public ConsumerThread(BlockingQueue queue) {

        this.queue = queue;
    }
    @Override
    public void run() {
        while(queue.isEmpty()){
            System.out.println("还没东西，等待一下");
            ThreadSleepTools.sleepSeconds(1);
        }
        queue.remove();
        System.out.println("当前队列还有 " + queue.size() + "未消费");

    }
}
