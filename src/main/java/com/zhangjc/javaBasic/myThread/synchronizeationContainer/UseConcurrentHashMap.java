package com.zhangjc.javaBasic.myThread.synchronizeationContainer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 2018/9/13.
 */
public class UseConcurrentHashMap {



    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put("nnn","1111");
        System.out.println("第1次"+ hashMap.get("nnn"));
        hashMap.put("nnn","2222");
        System.out.println(hashMap.put("nnn","3333"));
        System.out.println("第2次"+ hashMap.get("nnn"));
    }

}
