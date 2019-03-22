package com.zhangjc.javaBasic.myThread.basic;/**
 * Created by user on 2019/2/25.
 */

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TreadSleepUtil
 * @Description TODO
 * @Autor user
 * @Date 2019/2/25 17:12
 * @Version 1.0
 **/
public class TreadSleepUtil {

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
