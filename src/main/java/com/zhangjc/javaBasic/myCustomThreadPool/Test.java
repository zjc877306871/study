package com.zhangjc.javaBasic.myCustomThreadPool;/**
 * Created by user on 2018/11/5.
 */

/**
 * @ClassName Test
 * @Description TODO
 * @Autor user
 * @Date 2018/11/5 17:27
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Work work = new Work();
        CustomExcustor excustor = new CustomExcustor(work);
        excustor.pp();
        Thread.sleep(1000);
        System.out.println("jiiii");
    }
}
