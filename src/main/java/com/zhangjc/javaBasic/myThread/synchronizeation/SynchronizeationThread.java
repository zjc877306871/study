package com.zhangjc.javaBasic.myThread.synchronizeation;/**
 * Created by user on 2019/2/25.
 */

import com.zhangjc.javaBasic.myThread.basic.TreadSleepUtil;

/**
 * @ClassName SynchronizeationThread
 * @Description TODO
 * @Autor user
 * @Date 2019/2/25 16:58
 * @Version 1.0
 **/
public class SynchronizeationThread {


    //类所线程
    private static class SysClass implements Runnable{

        @Override
        public void run() {
            instance4();
        }
    }

    //对象锁线程
    private static class TomThread implements Runnable{

        private SynchronizeationThread synchronizeationThread;

        public TomThread(SynchronizeationThread synchronizeationThread) {
            this.synchronizeationThread = synchronizeationThread;
        }

        @Override
        public void run() {
            synchronizeationThread.instance2();
        }
    }
    //对象锁线程
    private static class JackThread implements Runnable{

        private SynchronizeationThread synchronizeationThread;

        public JackThread(SynchronizeationThread synchronizeationThread) {
            this.synchronizeationThread = synchronizeationThread;
        }

        @Override
        public void run() {
            synchronizeationThread.instance2();
        }
    }



    //对象锁
    private synchronized void instance1(){
        System.out.println("instance1被线程" + Thread.currentThread().getName() + "第1次调用");
        TreadSleepUtil.sleep(3);
        System.out.println("instance1被线程" + Thread.currentThread().getName() + "第2次调用");
        TreadSleepUtil.sleep(3);
    }

    //类锁代码块
    private void instance2(){
        synchronized (SynchronizeationThread.class){
            System.out.println("instance2被线程" + Thread.currentThread().getName() + "第1次调用");
            TreadSleepUtil.sleep(3);
            System.out.println("instance2被线程" + Thread.currentThread().getName() + "第2次调用");
            TreadSleepUtil.sleep(3);
        }

    }
    //对象锁代码块
    private void instance3(SynchronizeationThread thread){
        synchronized (thread){
            System.out.println("instance3被线程" + Thread.currentThread().getName() + "第1次调用");
            TreadSleepUtil.sleep(3);
            System.out.println("instance3被线程" + Thread.currentThread().getName() + "第2次调用");
            TreadSleepUtil.sleep(3);
        }

    }


    //类锁
    private static synchronized void instance4(){
        System.out.println("instance4被线程" + Thread.currentThread().getName() + "第1次调用");
        TreadSleepUtil.sleep(3);
        System.out.println("instance4被线程" + Thread.currentThread().getName() + "第2次调用");
        TreadSleepUtil.sleep(3);
    }



    public static void main(String[] args) {
        SynchronizeationThread thread = new SynchronizeationThread();
        SynchronizeationThread thread1 = new SynchronizeationThread();
        TomThread tomThread = new TomThread(thread);
        new Thread(tomThread).start();

        JackThread jackThread = new JackThread(thread1);
        new Thread(jackThread).start();

        //类锁测试
        SysClass sysClass1 = new SysClass();
        SysClass sysClass2 = new SysClass();

        new Thread(sysClass1).start();
        new Thread(sysClass2).start();

    }

}
