package com.zhangjc.javaBasic.batchFramework;/**
 * Created by zjc on 2018/9/23.
 */

import com.zhangjc.javaBasic.myThread.synchronizationTools.actoemic.ActormicInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * 对业务任务分组的job
 *
 * @author zjc
 * @create 2018-09-23 13:05
 */

public class JobInfo<R> {
    private final String jobName;
    //job的总长度
    private final int jobLength;
    //当前完成的成功任务
    private AtomicInteger successCount;
    //当前完成的总任务数量
    private AtomicInteger toatalCount;
    //储存任务结果的双向阻塞队列， 从后面放， 从前面取
    private LinkedBlockingDeque deque;
    //job的缓存有效期
    private final long activeTime;
    //task任务处理器
    private TaskExecutor<?,?> executor;

    public JobInfo(String jobName, int jobLength, long activeTime, TaskExecutor<?, ?> executor) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.activeTime = activeTime;
        this.executor = executor;
        this.successCount = new AtomicInteger(0);
        this.toatalCount = new AtomicInteger(0);
        this.deque = new LinkedBlockingDeque();
    }

    /**
     *提供获取任务处理器的方法
     * @return
     */
    public TaskExecutor<?,?> getExecutor(){
        return this.executor;
    }

    /**
     * 获取成功的次数
     * @return
     */
    public int getSuccessCount(){
        return successCount.get();
    }

    /**
     * 获取总进行次数
     * @return
     */
    public int getTotalCount(){
        return toatalCount.get();
    }

    /**
     * 获取失败的次数
     * @return
     */
    public int getFailCount(){
        return getTotalCount() - getSuccessCount();
    }

    public String getProcess(){
        return "任务总长度=" + jobLength + "已执行总任务数= " + getTotalCount()
                + "成功的任务数= " + getSuccessCount();
    }

    /**
     * 从结果队列中获取任务结果详情
     * @return
     */
    public List<ResultInfo<R>> getDetailsResult(){
        List<ResultInfo<R>> list = new LinkedList<>();
        ResultInfo<R> resultInfo;
        while((resultInfo = (ResultInfo<R>) deque.pollFirst()) != null){
            list.add(resultInfo);
        }
        return list;
    }

//    public void addTaskResult(){
//
//    }

}