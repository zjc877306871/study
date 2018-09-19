package com.zhangjc.javaBasic.myThread.synchronizationTools;

import java.util.concurrent.CountDownLatch;

/**
 * CoumtDownLatch  使用
 * Created by user on 2018/9/3.
 */
public class UseCoumtDownLantch {

    private static CountDownLatch latch = new CountDownLatch(5);

    /**
     * 初始化线程
     */
    public static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"准备初始化");
            latch.countDown();
            System.out.println(Thread.currentThread().getId()+"进行初始化");
        }
    }

    /**
     * 业务线程
     */
    public static class BusinessThread implements Runnable{

        @Override
        public void run() {
            try {
                latch.await();//阻塞线程，等待 计数器为零，继续执行业务代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 2; i++){
                System.out.println(Thread.currentThread().getId()+"do business");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println(name);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId()+"========进行第1步");
                latch.countDown();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+"========进行第2步");
                latch.countDown();
            }
        }).start();

        for(int i = 0; i < 3; i++){
            new Thread(new InitThread()).start();
        }

        new Thread(new BusinessThread()).start();
        latch.await();

        Thread.sleep(2000);
        System.out.println(name+"结束主线程");

    }

}
