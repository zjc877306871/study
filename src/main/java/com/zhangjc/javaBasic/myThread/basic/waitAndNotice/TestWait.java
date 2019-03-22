package com.zhangjc.javaBasic.myThread.basic.waitAndNotice;/**
 * Created by user on 2019/2/26.
 */

/**
 * @ClassName TestWait
 * @Description TODO
 * @Autor user
 * @Date 2019/2/26 14:22
 * @Version 1.0
 **/
public class TestWait {

    private static class ExpressWaitThread implements Runnable{

        private Express express;

        public ExpressWaitThread(Express express) {
            this.express = express;
        }

        @Override
        public void run() {
            System.out.println("当前等待线程：" + Thread.currentThread().getName() +
                "开始工作");
            try {
                express.waitKm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class ExpressChangeThread implements Runnable{

        private Express express;

        public ExpressChangeThread(Express express) {
            this.express = express;
        }

        @Override
        public void run() {
            System.out.println("当前改变的线程：" + Thread.currentThread().getName() +
                    "开始工作");
            express.changKm();
        }
    }


    public static void main(String[] args) {
        Express express = new Express("beijing",12);
        Express express1 = new Express("beijing",12);
        ExpressWaitThread wait = new ExpressWaitThread(express);
        ExpressChangeThread change = new ExpressChangeThread(express);
        Thread waitThread = new Thread(wait);
        Thread changeThread = new Thread(change);
        waitThread.setName("waitKm");
        changeThread.setName("changeKm");
        waitThread.start();
        changeThread.start();




    }

}
