package com.zhangjc.javaBasic.myThread.basic.volatileStudy;/**
 * Created by user on 2019/2/22.
 */

/**
 * @ClassName VolatileUnsafe
 * @Description TODO
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
            a++;
        }
    }




}
