package com.zhangjc.javaBasic.myThread.synchronizationTools.Lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2018/9/11.
 */
public class TestLock {

    public static class StatusThread implements Runnable{

        @Override
        public void run() {
            System.out.println("sjadjsia");
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park(this);
            System.out.println("3333"+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StatusThread ss = new StatusThread();
        Thread tt = new Thread(ss);
//        Thread tt1 = new Thread(ss);
//        Thread tt2 = new Thread(ss);
        tt.start();
//        tt1.start();
//        tt2.start();

        Thread.sleep(2000);

        // 中断线程
        tt.interrupt();



    }


}
