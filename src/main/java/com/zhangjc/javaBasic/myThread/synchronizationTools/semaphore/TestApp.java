package com.zhangjc.javaBasic.myThread.synchronizationTools.semaphore;

import java.sql.Connection;
import java.util.Date;
import java.util.Random;

/**
 * Created by user on 2018/9/6.
 */
public class TestApp {

    static DbPoolSemaphore semaphore = new DbPoolSemaphore();
    public static class PoolThread implements Runnable{

        @Override
        public void run() {
            try {
                Long start = System.currentTimeMillis();
                Connection connection = semaphore.getConnection();
                //通过随机数限制线程睡眠时间
                Random random = new Random();
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +"_获取数据库连接共耗时【"+(System.currentTimeMillis()-start)+"】ms.");
                Thread.sleep(200+random.nextInt(100));
                semaphore.releaseConnection(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
           new Thread(new PoolThread()).start();
        }

    }
}
