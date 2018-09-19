package com.zhangjc.javaBasic.myThread.synchronizationTools;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by user on 2018/9/6.
 */
public class UseFuther {

    public static class UserCall implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("当前线程id" + Thread.currentThread().getId());
            Random random = new Random();
            int ll = random.nextInt();
            return ll;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable countInterge = new UserCall();
        FutureTask task = new FutureTask(countInterge);
        new Thread(task).start();

        Random random = new Random();
        if(random.nextBoolean()){
            System.out.println(task.get());
        }else{
            System.out.println("中断请求");
            task.cancel(true);
        }
    }



}
