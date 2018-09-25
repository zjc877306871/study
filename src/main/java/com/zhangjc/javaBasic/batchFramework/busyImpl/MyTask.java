package com.zhangjc.javaBasic.batchFramework.busyImpl;/**
 * Created by user on 2018/9/25.
 */

import com.zhangjc.javaBasic.batchFramework.ResultInfo;
import com.zhangjc.javaBasic.batchFramework.ResultType;
import com.zhangjc.javaBasic.batchFramework.TaskExecutor;
import com.zhangjc.javaBasic.myThread.ThreadSleepTools;

import java.util.Random;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Autor user
 * @Date 2018/9/25 14:35
 * @Version 1.0
 **/
public class MyTask implements TaskExecutor<Integer,Integer>{

    @Override
    public ResultInfo<Integer> executeTask(Integer data) {
        Random r = new Random();
        int flag = r.nextInt(10);
        ThreadSleepTools.sleepMs(flag);
        if(flag<=300) {//正常处理的情况
            Integer returnValue = data.intValue()+flag;
            return new ResultInfo<Integer>(ResultType.SUCCESS,returnValue);
        }else if(flag>301&&flag<=400) {//处理失败的情况
            return new ResultInfo<Integer>(ResultType.FAIL,-1,"Failure");
        }else {//发生异常的情况
            try {
                throw new RuntimeException("异常发生了！！");
            } catch (Exception e) {
                return new ResultInfo<Integer>(ResultType.EXCEPTION,
                        -1,e.getMessage());
            }
        }
    }
}
