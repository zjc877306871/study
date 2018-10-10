package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.sql;/**
 * Created by user on 2018/10/10.
 */

import com.zhangjc.javaBasic.myThread.ThreadSleepTools;

/**
 * @ClassName BussinessSql
 * @Description 模拟实际业务的数据操作
 * @Autor user
 * @Date 2018/10/10 15:05
 * @Version 1.0
 **/
public class BussinessSql {
    public static void business(int sleepTime){
        ThreadSleepTools.sleepMs(sleepTime);
    }
}
