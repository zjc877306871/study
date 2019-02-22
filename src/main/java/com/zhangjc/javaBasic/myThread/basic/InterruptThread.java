package com.zhangjc.javaBasic.myThread.basic;/**
 * Created by user on 2019/2/22.
 */

/**
 * @ClassName InterruptThread
 * @Description 测试Thread的interrupt的用法和isInterrupted的用法
 * java线程是协作式，而非抢占式
   调用一个线程的interrupt() 方法中断一个线程，并不是强行关闭这个线程，只是跟这个线程打个招呼，将线程的中断标志位置为true，线程是否中断，由线程本身决定。
   isInterrupted() 判定当前线程是否处于中断状态。
   static方法interrupted() 判定当前线程是否处于中断状态，同时中断标志位改为false。
   方法里如果抛出InterruptedException，线程的中断标志位会被复位成false，如果确实是需要中断线程，要求我们自己在catch语句块里再次调用interrupt()。

 * @Autor user
 * @Date 2019/2/22 16:10
 * @Version 1.0
 * 当时用线程睡眠的方法时，Thread.sleep。如果使用thread.interruput()方法。会抛出异常。所以sleep
 * 方法要通过try、catch捕获异常
 **/
public class InterruptThread {

    private static class ThreadInterrupt implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程的名字 : "+Thread.currentThread().getName()
            + "当前时间是" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println("当前线程"+ Thread.currentThread().getName()+
                        "结束睡眠，当前时间" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                //方法里如果抛出InterruptedException，线程的中断标志位会被复位成false，
                // 如果确实是需要中断线程，要求我们自己在catch语句块里再次调用interrupt()。
                System.out.println("当前线程"+ Thread.currentThread().getName()+
                        "第2次查看线程状态：" + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("当前线程"+ Thread.currentThread().getName()+
                        "第4次查看线程状态：" + Thread.currentThread().isInterrupted());
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread interruputThread = new Thread(new ThreadInterrupt());
        interruputThread.start();

        System.out.println("当前线程"+ Thread.currentThread().getName()+
                "第1次查看线程状态：" + Thread.currentThread().isInterrupted());

//        Thread.sleep(2000);
        interruputThread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("当前线程"+ Thread.currentThread().getName()+
                "第3次查看线程状态：" + Thread.currentThread().isInterrupted());
        //static方法interrupted() 判定当前线程是否处于中断状态，同时中断标志位改为false。
        Thread.interrupted();
        System.out.println("当前线程"+ Thread.currentThread().getName()+
                "第5次查看线程状态：" + Thread.currentThread().isInterrupted());
        interruputThread.interrupt();
        Thread.sleep(2000);


    }

}
