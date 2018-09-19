package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.queue.entry.People;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 模拟生产者生成信息插入队列
 * Created by user on 2018/9/19.
 */
public class ProductThread implements Runnable{

    BlockingQueue queue ;

    public ProductThread(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        People pp = new People();
        pp.setAge(2 + r.nextInt());
        queue.add(pp);
    }
}
