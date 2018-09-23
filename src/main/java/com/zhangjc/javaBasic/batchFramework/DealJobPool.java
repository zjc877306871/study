package com.zhangjc.javaBasic.batchFramework;/**
 * Created by zjc on 2018/9/23.
 */

import java.util.List;
import java.util.concurrent.*;

/**
 * 描述:
 * 多线程处理job任务
 *
 * @author zjc
 * @create 2018-09-23 14:01
 */

public class DealJobPool {
    //储存job任务的缓存容器
    private static ConcurrentHashMap<String, JobInfo<?>> hashMap;
    //负责缓存Task的阻塞队列
    private static BlockingQueue<Runnable> queue;
    //获取当前服务器的CPU数
    private static final int cpuCount = Runtime.getRuntime().availableProcessors();

    private static CheckProcessJob checkProcessJob =  CheckProcessJob.getInstance();;
    //执行任务的线程池
    private ExecutorService poolExecutor = new ThreadPoolExecutor(cpuCount,cpuCount,
            60,TimeUnit.SECONDS,queue);

    //利用内部类实现单例模式懒汉式

    public DealJobPool() {
    }

    private static class DealPoolHandle {
        private static DealJobPool pool = new DealJobPool();
    }
    public static DealJobPool getPool(){
        return DealPoolHandle.pool;
    }

    //利用内部类实现单例模式懒汉式


    public static ConcurrentHashMap<String, JobInfo<?>> getMap(){
        return hashMap;
    }

    /**
     * //对工作中的任务进行包装，提交给线程池使用，并处理任务的结果，写入缓存以供查询
     * @param <R>
     * @param <T>
     */
    public static class DealTask<R,T> implements Runnable{

        private JobInfo<R> jobInfo;
        private T data;

        public DealTask(JobInfo<R> jobInfo, T data) {
            this.jobInfo = jobInfo;
            this.data = data;
        }

        @Override
        public void run() {
            R r = null;
            //获取任务的处理器
            TaskExecutor<R,T> executor = (TaskExecutor<R, T>) jobInfo.getExecutor();
            //执行业务人员的业务代码
            ResultInfo<R> result = executor.executeTask(data);
            jobInfo.addTaskResult(result,checkProcessJob);

        }
    }



    /**
     *  //根据工作名称检索工作任务
     * @param jobName
     * @param <R>
     * @return
     */
    public <R> JobInfo<R> checkJob(String jobName){
        JobInfo<R> jobInfo = (JobInfo<R>) hashMap.get(jobName);
        if(null == jobInfo){
            throw new RuntimeException("未获取到job任务");
        }
        return jobInfo;
    }

    //调用者提交工作中的任务
    public <R,T> void putTask(String jobName, T data){
        JobInfo<R> jobInfo = (JobInfo<R>) hashMap.get(jobName);
        DealTask task = new DealTask(jobInfo,data);
        poolExecutor.execute(task);
    }



    /**
     * 注册job信息
     * @param jobName
     * @param jobLength
     * @param activeTime
     * @param executor
     */
    public void rejectJob(String jobName, int jobLength, long activeTime, TaskExecutor<?, ?> executor){
        JobInfo jobInfo = new JobInfo(jobName,jobLength,activeTime,executor);
        hashMap.putIfAbsent(jobName,jobInfo);
    }


    /**
     * //获得每个任务的处理详情
     * @param jobName
     * @param <R>
     * @return
     */
    public <R> List<ResultInfo<R>> getResultList(String jobName){
        JobInfo<R> jobInfo = (JobInfo<R>) hashMap.get(jobName);
        return jobInfo.getDetailsResult();
    }


    /**
     *获得工作的整体处理进度
     * @param jobName
     * @param <R>
     * @return
     */
    public <R> int getTotalCount(String jobName){
        JobInfo<R> jobInfo = (JobInfo<R>) hashMap.get(jobName);
        return jobInfo.getTotalCount();
    }

}