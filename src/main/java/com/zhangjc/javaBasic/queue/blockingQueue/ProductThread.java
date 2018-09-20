package com.zhangjc.javaBasic.queue.blockingQueue;

import com.zhangjc.javaBasic.queue.entry.People;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 模拟生产者生成信息插入队列
 * Created by user on 2018/9/19.
 */
public class ProductThread implements Runnable{

    public static final String ADD = "add"; //队列满时，抛出异常
    public static final String OFFER = "offer";//返回添加结果  true/false
    public static final String PUT = "put"; //如果队列满。线程一直阻塞

    BlockingQueue queue ;
    private String monthName;
    private String firstOrLast;

    public ProductThread(BlockingQueue queue, String monthName, String firstOrLast) {
        this.queue = queue;
        this.monthName = monthName;
        this.firstOrLast = firstOrLast;
    }

    public ProductThread(BlockingQueue queue, String monthName) {
        this.queue = queue;
        this.monthName = monthName;
    }

    public ProductThread(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        if(monthName == null || monthName == ""){
            System.out.println("无法识别是哪一个方法操作");
            throw new RuntimeException("null指针");
        }else if(ADD == monthName){
            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    queueNew.addFirst(pp);
                }else{
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    queueNew.addLast(pp);
                }
            }else{
                Random r = new Random();
                People pp = new People();
                pp.setAge(2 + r.nextInt());
                queue.add(pp);
                System.out.println(Thread.currentThread().getName()+" 的add添加方法已完成");
            }

        }else if(OFFER == monthName){
            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    if(queueNew.offerFirst(pp)){
                        System.out.println(queueNew.offerFirst(pp));
                    }
                    System.out.println(queueNew.offerFirst(pp));
                }else{
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    queueNew.offerLast(pp);
                }
            }else{
                Random r = new Random();
                People pp = new People();
                pp.setAge(2 + r.nextInt());
                queue.offer(pp);
                System.out.println(Thread.currentThread().getName()+" 的offer添加方法已完成");
            }

        }else if(PUT == monthName){
            if(queue instanceof LinkedBlockingDeque){
                if("1".equals(firstOrLast)){
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    try {
                        queueNew.putFirst(pp);
                    } catch (InterruptedException e) {
                        System.out.println("当前线程 "+ Thread.currentThread().getName() + "操作的putFirst方法出现异常");
                    }
                }else{
                    Random r = new Random();
                    People pp = new People();
                    pp.setAge(2 + r.nextInt());
                    LinkedBlockingDeque queueNew = (LinkedBlockingDeque) queue;
                    try {
                        queueNew.putLast(pp);
                    } catch (InterruptedException e) {
                        System.out.println("当前线程 "+ Thread.currentThread().getName() + "操作的putLast方法出现异常");
                    }
                }
            }else {
                Random r = new Random();
                People pp = new People();
                pp.setAge(2 + r.nextInt());
                try {
                    queue.put(pp);
                    System.out.println(Thread.currentThread().getName()+" 的put添加方法已完成");
                } catch (InterruptedException e) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + "操作的put方法出现异常");
                }
            }
         }else{
            System.out.println("出现错误！！！！！！！！！！！！");
        }

    }
}
