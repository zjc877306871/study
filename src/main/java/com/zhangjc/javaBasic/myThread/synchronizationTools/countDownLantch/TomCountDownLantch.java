package com.zhangjc.javaBasic.myThread.synchronizationTools.countDownLantch;/**
 * Created by user on 2019/3/22.
 */

import com.zhangjc.javaBasic.myThread.basic.TreadSleepUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TomCountDownLantch
 * @Description 使用说明：初始化CountDownLatch一定值。每满足一个条件， countDownLatch.countDown();当CountDownLatch
 * 初始值被减到0时。会同时执行countDownLatch.await后面的代码。条件线程和具体业务的线程不一定是相同的。
 * 就好比CountDownLatch是一个栅栏。D/E/F/G被CountDownLatch阻塞，等待执行。只有当A/B/C都到达栅栏。即CountDownLatch的值变成0
 * 那么D/E/F/G才会同时执行。
 * @Autor user
 * @Date 2019/3/22 16:32
 * @Version 1.0
 **/
public class TomCountDownLantch {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    /**
     * 控制初始化线程
     */
    private static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程名字：" + Thread.currentThread().getName() +
                    "开始执行,当前等待线程的数量：" + countDownLatch.getCount());
            countDownLatch.countDown();
        }
    }


    /**
     * 业务线程
     */
    private static class WorkThread implements Runnable{

        @Override
        public void run() {

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i=0; i<3; i++){
                System.out.println("一切准备就绪，开始工作的线程名字：" +
                        Thread.currentThread().getName());
            }


        }
    }

    /**
     * 业务和控制集合一起的线程
     */
    private static class BothThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程名字：" + Thread.currentThread().getName() +
                    "开始执行,当前等待线程的数量：" + countDownLatch.getCount());
            countDownLatch.countDown();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一切准备就绪，开始工作的线程名字：" +
                    Thread.currentThread().getName());

        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("当前线程名字：" + Thread.currentThread().getName() +
                "开始执行,当前等待线程的数量：" + countDownLatch.getCount());

        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println("线程：" + Thread.currentThread().getName() +
                        "准备开始工作,当前还未到达线程的数量：" + countDownLatch.getCount());

                TreadSleepUtil.sleep(2);
                countDownLatch.countDown();
                System.out.println("线程：" + Thread.currentThread().getName() +
                        "准备结束工作,当前还未到达线程的数量：" + countDownLatch.getCount());
            }
        }).start();


        for(int i=0; i<3; i++){
            Thread thread = new Thread(new BothThread());
            thread.setName(String.valueOf(i));
            thread.start();
        }

        new Thread(new WorkThread()).start();
        System.out.println("紧挨着业务线程");
        countDownLatch.await();

        TreadSleepUtil.sleep(5);
        System.out.println("当前线程名字：" + Thread.currentThread().getName() +
                "结束主线程");
    }

}
