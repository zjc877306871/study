package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.queue.entry.People;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by user on 2018/9/19.
 */
public class UseLinkedBlockingQueue {

    public static void main(String[] args) {
        LinkedBlockingQueue<People> linkedBlockingDeque = new LinkedBlockingQueue();
        String monthName1 = "offer";
        String monthName2 = "poll";
        ProductThread productThread = new ProductThread(linkedBlockingDeque,monthName1);
        ConsumerThread consumerThread = new ConsumerThread(linkedBlockingDeque,monthName2);

        for(int i = 0; i < 13; i++){
            new Thread(productThread).start();
        }

        for(int i = 0; i < 12; i++){
            new Thread(consumerThread).start();
        }

    }
}
