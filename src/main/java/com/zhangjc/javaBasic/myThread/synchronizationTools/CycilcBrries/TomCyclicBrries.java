package com.zhangjc.javaBasic.myThread.synchronizationTools.CycilcBrries;/**
 * Created by user on 2019/3/22.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName TomCyclicBrries
 * @Description TODO
 * @Autor user
 * @Date 2019/3/22 17:21
 * @Version 1.0
 **/
public class TomCyclicBrries {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Thread(new CountThread()));
    private static ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();
    /**
     * 统计线程
     */
    private static class CountThread implements Runnable{

        @Override
        public void run() {
            for(Map.Entry<String, Long> entry : hashMap.entrySet()){

            }
        }
    }

}
