package com.zhangjc.javaBasic.batchFramework.busyImpl;/**
 * Created by user on 2018/9/25.
 */

import com.zhangjc.javaBasic.batchFramework.DealJobPool;
import com.zhangjc.javaBasic.batchFramework.ResultInfo;
import com.zhangjc.javaBasic.myThread.ThreadSleepTools;

import java.util.List;
import java.util.Random;

/**
 * @ClassName TaskTest
 * @Description TODO
 * @Autor user
 * @Date 2018/9/25 15:37
 * @Version 1.0
 **/
public class TaskTest {
    private final static String JOB_NAME = "计算数值";
    private final static int JOB_LENGTH = 1000;

    public static class QueryThread implements Runnable{

        private DealJobPool dealJobPool;

        public QueryThread(DealJobPool dealJobPool) {
            this.dealJobPool = dealJobPool;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 350){
                List<ResultInfo<Integer>> taskDetail = dealJobPool.getResultList(JOB_NAME);
                if(!taskDetail.isEmpty()) {
                    System.out.println(dealJobPool.getTotalCount(JOB_NAME));
                    System.out.println(taskDetail);
                }
                ThreadSleepTools.sleepMs(10);
                i++;
            }
        }
    }


    public static void main(String[] args) {

        MyTask task = new MyTask();
        DealJobPool pool = DealJobPool.getPool();
        pool.rejectJob(JOB_NAME,JOB_LENGTH,10000*5,task);
        Random r = new Random();
        for(int i=0;i<JOB_LENGTH;i++) {
            //依次推入Task
            pool.putTask(JOB_NAME, r.nextInt(1000));
        }
        new Thread(new QueryThread(pool)).start();

    }
}
