package com.zhangjc.javaBasic.myThread.synchronizationTools.actoemic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 2018/9/6.
 */
public class ActormicInteger {
    static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {

        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.incrementAndGet());
    }

}
