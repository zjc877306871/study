package com.zhangjc.javaBasic.myCustomThreadPool;/**
 * Created by user on 2018/11/5.
 */

/**
 * @ClassName Work
 * @Description TODO
 * @Autor user
 * @Date 2018/11/5 17:12
 * @Version 1.0
 **/
public class Work implements Excustor{
    public void work() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("3333333333333333");
    }
}
