package com.zhangjc.javaBasic.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by user on 2018/9/18.
 */
public class UseExecutorPoolThread {

    /**
     * 没有返回值的线程任务
     */
    public static class NoReturnThread extends Thread{

        String taskName ;

        public NoReturnThread(String taskName) {
            this.taskName = taskName;
        }

        Random rr = new Random();

        @Override
        public void run() {
            try {
                Thread.sleep(200+ rr.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前工作线程的名字 " + taskName + Thread.currentThread().getName());
        }
    }


    /**
     * 有返回值的工作线程
     */
    public static class ReturnThread implements Callable<String>{

        private  String taskName ;

        public ReturnThread(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public String call() throws Exception {
            Random andom = new Random();
            Thread.sleep(andom.nextInt(100)+300);
            System.out.println("有返回值线程名字 "+ Thread.currentThread().getName());
            return "1";
        }


    }





    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //自定义线程对象
        ExecutorService myPools = new ThreadPoolExecutor(2,10,1, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6),
                new ThreadPoolExecutor.DiscardOldestPolicy()) ;

        for(int i = 0; i < 20; i++){
            Thread work1 = new NoReturnThread("work1" + i);
            myPools.execute(work1);
        }

//        for(int i = 0; i < 6; i++){
//            Callable<String> callWork = new ReturnThread("callWork" + i);
//            Future<String> task = myPools.submit(callWork);
//            String ss = task.get();
//            System.out.println(ss);
//        }




    }

}
