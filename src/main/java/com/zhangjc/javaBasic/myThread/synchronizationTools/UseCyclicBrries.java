package com.zhangjc.javaBasic.myThread.synchronizationTools;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by user on 2018/9/3.
 */
public class UseCyclicBrries {
    private static ConcurrentHashMap<String,Long> concurrentMap = new ConcurrentHashMap<>();

    //如果构造参数带有线程对象new CountThread()时，，，当parties的值被线程使用完后（即执行了parties次 await()
    // 方法。所有的等待线程同时开启await()后的业务逻辑。且new CountThread()的业务方法也同时执行。）
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CountThread());

    /**
     * 统计线程
     */
    public static class CountThread implements Runnable{

        StringBuilder builder = new StringBuilder();
        @Override
        public void run() {
            String result = null;
            for(Map.Entry<String,Long> entry: concurrentMap.entrySet()){
                result = builder.append(entry.getValue()).toString();

            }
            System.out.println("累计有"+result+"个工作线程");
        }
    }

    public static class BusinessThread implements Runnable{

        @Override
        public void run() {
            System.out.println("做一些公共的业务准备工作");
            concurrentMap.put(Thread.currentThread().getId()+"",Thread.currentThread().getId());
            Random random = new Random();
            try {
                if(random.nextBoolean()){
                    System.out.println(Thread.currentThread().getId()+"操作1111");
                }
                System.out.println(Thread.currentThread().getId()+"操作2222");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("进行各自的业务继续");
        }
    }


    public static void main(String[] args) {
        System.out.println("开始线程名字"+Thread.currentThread().getName());
        for(int i = 0; i < 3; i++){
            new Thread(new BusinessThread()).start();
        }
    }


}
