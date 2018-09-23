package com.zhangjc.javaBasic.batchFramework;/**
 * Created by zjc on 2018/9/23.
 */

import com.zhangjc.javaBasic.queue.blockingQueue.delayQueue.PackOrder;

import java.util.concurrent.DelayQueue;

/**
 * 描述:
 * 监控任务结果是否时效
 *
 * @author zjc
 * @create 2018-09-23 21:58
 */

public class CheckProcessJob {
    private static  DelayQueue<PackOrder<String>> queue = new DelayQueue<>();


    //利用内部类实现单例模式懒汉式

    public CheckProcessJob() {
    }

    public static class CheckProcessJobHandle{
        private static CheckProcessJob pool = new CheckProcessJob();

        public static CheckProcessJob getInstance(){
            return CheckProcessJobHandle.pool;
        }
    }
    //利用内部类实现单例模式懒汉式


    //处理过期订单的单独线程
    private static class DealOrderThread implements Runnable{

        @Override
        public void run() {
            while (true){
                //拿到过期的job任务
                try {
                    PackOrder<String> order = queue.poll();
                    String jobName = order.getDate();
                    DealJobPool.getMap().remove(jobName);
                    System.out.println(jobName+" is out of date,remove from map!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 任务完成后，放入队列，经过expireTime时间后，从整个框架中移除
     * @param jobName
     * @param activeTime
     */
    public void putJob(String jobName, long activeTime){
        PackOrder<String> packOrder = new PackOrder<>(activeTime,jobName);
        queue.add(packOrder);
        System.out.println("Job["+jobName+"已经放入了过期检查缓存，过期时长："+ activeTime);
    }


    static {
        Thread thread = new Thread(new DealOrderThread());
        thread.setDaemon(true);
        thread.start();
        System.out.println("开启任务过期检查守护线程................");
    }

}