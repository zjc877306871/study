package com.zhangjc.javaBasic.myThread.basic.waitAndNotice;
/**
 * Created by user on 2019/2/26.
 */

import com.zhangjc.javaBasic.myThread.basic.TreadSleepUtil;

/**
 * @ClassName Express
 * @Description 快递实例
 * @Autor user
 * @Date 2019/2/26 13:53
 * @Version 1.0
 **/
public class Express {
    private final static String CITY = "shangHai";
    private String site;
    private int km;

    public Express(String site, int km) {
        this.site = site;
        this.km = km;
    }

    //变更公里数，并通知wait的任务开始
    public void  changKm(){
        synchronized (this){
            System.out.println("当前变更行程数开始，线程名字 ：" + Thread.currentThread().getName());
            TreadSleepUtil.sleep(5);
            System.out.println("当前变休眠结束，线程名字 ：" + Thread.currentThread().getName());
            this.notifyAll();
            System.out.println("当前变更行程数结束，线程名字 ：" + Thread.currentThread().getName());
        }

    }

    //变更目的地，比通知wait的任务开始
    public void changeSite(){
        synchronized (this){
            System.out.println("当前变更目的地开始，线程名字 ：" + Thread.currentThread().getName());
            TreadSleepUtil.sleep(2);
            Thread.currentThread().notifyAll();
            System.out.println("当前变更目的地结束，线程名字 ：" + Thread.currentThread().getName());
        }
    }

    public void waitKm() throws InterruptedException {
        synchronized (this) {
            System.out.println("当前等待行程数开始，线程名字 ：" + Thread.currentThread().getName());
            this.wait();
            System.out.println("当前等待行程数结束，线程名字 ：" + Thread.currentThread().getName());
        }
    }

    public void  waitSite() throws InterruptedException {
        synchronized (this) {
            System.out.println("当前等待目的地开始，线程名字 ：" + Thread.currentThread().getName());
            this.wait();
            System.out.println("当前等待目的地结束，线程名字 ：" + Thread.currentThread().getName());
        }

    }
}
