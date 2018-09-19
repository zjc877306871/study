package com.zhangjc.javaBasic.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by user on 2018/9/18.
 */
public class UseFixedThreadPool {

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(400);
                System.out.println("当前线程的名字" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 20; i++){
            Thread tt = new Thread(new MyThread());
            fixedPool.execute(tt);
        }

    }

}
