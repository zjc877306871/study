package com.zhangjc.javaBasic.myThread.basic;/**
 * Created by user on 2019/2/22.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName Threads
 * @Description 线程的几种实现
 * @Autor user
 * @Date 2019/2/22 17:04
 * @Version 1.0
 **/
public class Threads {

    //继承Thread实现线程
    private static class ExtendThread extends Thread{

        public ExtendThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("当前线程名字=" + Thread.currentThread().getName()+
                "继承了Thread类");
        }
    }

    //实现Runnable接口来创建线程
    private static class ImpThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程名字=" + Thread.currentThread().getName()+
                "实现了Runnable");
        }
    }

    /*实现Callable接口，允许有返回值*/
    private static class CallableThread implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("当前线程名字=" + Thread.currentThread().getName() +
                "实现了Callable");
            Thread.sleep(2000);

            return "12345";
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread a = new ExtendThread("aaa");
        Thread b = new Thread(new ImpThread());
        b.setName("bbb");
        a.start();
        b.start();

        Callable call = new CallableThread();
        FutureTask<String> task = new FutureTask<String>(call);
        Thread c = new Thread(task);
        c.setName("ccc");
        c.start();
        String s = task.get();
        System.out.println(s);

    }

}
