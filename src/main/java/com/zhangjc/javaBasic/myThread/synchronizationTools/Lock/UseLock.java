package com.zhangjc.javaBasic.myThread.synchronizationTools.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2018/9/6.
 */
public class UseLock {

    public static class BusinessThread implements Runnable{
        Lock lock = new ReentrantLock();
        private int count;
        @Override
        public void run() {
            lock.lock();
            try{
                count++;
                System.out.println("枷锁来啦"+count);
            }finally {
                lock.unlock();
            }
        }
    }
}
