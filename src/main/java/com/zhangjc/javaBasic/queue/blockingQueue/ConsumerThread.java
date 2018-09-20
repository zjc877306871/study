package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;
import com.zhangjc.javaBasic.queue.entry.People;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 模拟消费者进行消费队列信息
 * Created by user on 2018/9/19.
 */
public class ConsumerThread implements Runnable{

    public static final String REMOVE = "remove"; //如果阻塞队列为空，抛出异常
    public static final String POLL = "poll"; //返回获取结果 true/false
    public static final String TAKE = "take"; //如果队列为空，线程一直阻塞

    BlockingQueue queue ;
    private String monthName;
    private String firstOrLast;

    public ConsumerThread(BlockingQueue queue, String monthName, String firstOrLast) {
        this.queue = queue;
        this.monthName = monthName;
        this.firstOrLast = firstOrLast;
    }
    public ConsumerThread(BlockingQueue queue, String monthName) {
        this.queue = queue;
        this.monthName = monthName;
    }

    public ConsumerThread(BlockingQueue queue) {

        this.queue = queue;
    }
    @Override
    public void run() {

        if(monthName == null || monthName == ""){
            System.out.println("无法识别是哪一个方法操作");
            throw new RuntimeException("null指针");
        }else if(REMOVE == monthName){
            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    System.out.println("当前队列还有 " + queue.size() + "未消费");
                    ((LinkedBlockingDeque) queue).removeFirst();
                }else{
                    System.out.println("当前队列还有 " + queue.size() + "未消费");
                    ((LinkedBlockingDeque) queue).removeLast();
                }
            }else {
                System.out.println("当前队列还有 " + queue.size() + "未消费");
                queue.remove();
            }
        }else if(POLL == monthName){
            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    System.out.println("当前队列还有 " + queue.size() + "未消费");
                    ((LinkedBlockingDeque) queue).pollFirst();
                }else{
                    System.out.println("当前队列还有 " + queue.size() + "未消费");
                    ((LinkedBlockingDeque) queue).pollLast();
                }
            }else {
                People p = (People) queue.poll();
                if(p != null){
                    System.out.println("获取的用户的年纪是 "+ p.getAge());
                }
                System.out.println("当前队列还有 " + queue.size() + "未消费");
            }

        }else if(TAKE == monthName){

            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    System.out.println("当前队列还有 " + queue.size() + "未消费");
                    try {
                        ((LinkedBlockingDeque)queue).takeFirst();
                    } catch (InterruptedException e) {
                        System.out.println("当前线程 "+ Thread.currentThread().getName() + "操作的take方法出现异常");
                    }
                }else{
                    try {
                        ((LinkedBlockingDeque)queue).takeLast();
                    } catch (InterruptedException e) {
                        System.out.println("当前线程 "+ Thread.currentThread().getName() + "操作的take方法出现异常");
                    }
                }
            }else {

                try {
                   People pp = (People) queue.take();
                   if(pp != null){
                       System.out.println("take的年纪 " + pp.getAge());
                   }
                   System.out.println("当前队列还有 " + queue.size() + "未消费");
                } catch (InterruptedException e) {
                    System.out.println("当前线程 "+ Thread.currentThread().getName() + "操作的take方法出现异常");
                }
            }
        }else{
            System.out.println("未知错误！！！！！");
        }



    }
}
