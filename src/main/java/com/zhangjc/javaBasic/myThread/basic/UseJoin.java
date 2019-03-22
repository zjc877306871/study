package com.zhangjc.javaBasic.myThread.basic;/**
 * Created by user on 2019/2/26.
 */

/**
 * @ClassName UseJoin
 * @Description 若果在线程A的run方法中执行线程B类的join()方法。只有等线程B的线程任务结束了。线程A才能结束
 * @Autor user
 * @Date 2019/2/26 11:19
 * @Version 1.0
 **/
public class UseJoin {

    private static class WorkThread implements Runnable{

        private Thread thread;

        public WorkThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            //TODO
            try {
                System.out.println("当前线程名字 ：" + Thread.currentThread().getName());
                thread.join();

                TreadSleepUtil.sleep(1);
                System.out.println("当前线程名字 ：" + Thread.currentThread().getName() +
                        "结束睡眠开始工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0; i<10; i++){
            WorkThread work = new WorkThread(previous);
            Thread thread = new Thread(work);
            thread.setName("work"+i);
            thread.start();
            previous = thread;
        }
        //当前主线程睡眠
        TreadSleepUtil.sleep(10);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }




}
