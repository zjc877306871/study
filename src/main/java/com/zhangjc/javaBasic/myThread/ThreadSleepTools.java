package com.zhangjc.javaBasic.myThread;

/**
 * Created by user on 2018/9/18.
 */
public class ThreadSleepTools {

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMs(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
