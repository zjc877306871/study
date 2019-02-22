package com.zhangjc.javaBasic.myCustomThreadPool;/**
 * Created by user on 2018/11/5.
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CustomExcustor
 * @Description TODO
 * @Autor user
 * @Date 2018/11/5 16:25
 * @Version 1.0
 **/
public class CustomExcustor {
    private static Excustor content;

    private static class WorkThread implements Runnable{

        @Override
        public void run() {
            try {
                content.work();
                System.out.println("异步已经结束----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public CustomExcustor(Excustor content) {
        this.content = content;
    }

    private static ExecutorService service = Executors.newFixedThreadPool(20);

    public void pp(){
        service.execute(new WorkThread());
    }








}
