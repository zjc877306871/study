package com.zhangjc.javaBasic.threadPool.scheduled;

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *测试 scheduleAtFixedRate  方法  是按照固定时间   执行任务，即任务开始的时间间隔是固定的
 * Created by user on 2018/9/18.
 */
public class ScheduledTask implements Runnable{

    public final static int EIGHT_SECOND = 8;
    public final static int TWO_SECOND = 2;
    public final static int TEN_SECOND = 10;
    private static SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private AtomicInteger count = new AtomicInteger();


    @Override
    public void run() {

        if(count.get() == 0){
            System.out.println("EIGHT_SECOND开始时间= " + ss.format(new Date()));
            ThreadSleepTools.sleepSeconds(8);
            System.out.println("EIGHT_SECOND结束时间= " + ss.format(new Date()));
            count.incrementAndGet();
        }else if(count.get() == 1){
            System.out.println("TWO_SECOND 开始时间= " + ss.format(new Date()));
            ThreadSleepTools.sleepSeconds(2);
            System.out.println("TWO_SECOND 结束时间= " + ss.format(new Date()));
            count.incrementAndGet();
        }else{
            System.out.println("TEN_SECOND 开始时间= " + ss.format(new Date()));
            ThreadSleepTools.sleepSeconds(10);
            System.out.println("TEN_SECOND 结束时间= " + ss.format(new Date()));
            count.incrementAndGet();
        }

    }


    public static void main(String[] args) {

        ScheduledTask task = new ScheduledTask();
        ScheduledExecutorService ss = Executors.newScheduledThreadPool(1);
        ss.scheduleAtFixedRate(task,0,6, TimeUnit.SECONDS);

    }
}
