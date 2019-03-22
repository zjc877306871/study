package com.zhangjc.javaBasic.myThread.basic.volatileStudy;/**
 * Created by user on 2019/2/22.
 */

/**
 * @ClassName VolatileUnsafe
 * @Description 演示violate无法提供操作的原子性
 * @Autor user
 * @Date 2019/2/22 17:27
 * @Version 1.0
 **/
public class VolatileUnsafe {

    private static class UnsafeVolatile implements Runnable{
        private volatile int a = 0;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            a = a++;
            System.out.println("线程名字是 : "+threadName+"第1次计算值 ："+ a);
            a = a+1;
            System.out.println("线程名字是 : "+threadName+"第2次计算值 ："+ a);
        }
    }


    public static void main(String[] args) {
        UnsafeVolatile unsafeVolatile = new UnsafeVolatile();
        Thread a = new Thread(unsafeVolatile);
        Thread b = new Thread(unsafeVolatile);
        Thread c = new Thread(unsafeVolatile);
        Thread d = new Thread(unsafeVolatile);

        a.start();
        b.start();
        c.start();
        d.start();



    }



}
