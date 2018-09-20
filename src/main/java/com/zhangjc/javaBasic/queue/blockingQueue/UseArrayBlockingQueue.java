package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;
import com.zhangjc.javaBasic.queue.entry.People;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue   是基于数组实现的有界阻塞队列
 * 按照先进先出的原则，初始化时要求设定队列的大小
 * Created by user on 2018/9/18.
 */
public class UseArrayBlockingQueue {


    public static void main(String[] args) {

        ArrayBlockingQueue<People> queue = new ArrayBlockingQueue<People>(10);

        String monthNmae1 = "remove";
        ProductThread productThread = new ProductThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue,monthNmae1);

//        for(int i = 0; i < 13; i++){
//            new Thread(productThread).start();
//        }
        for(int i = 0; i < 12; i++){
            new Thread(consumerThread).start();
        }


    }

}
