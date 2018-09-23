package com.zhangjc.javaBasic.batchFramework;

/**
 * Created by zjc on 2018/9/23.
 */
public interface TaskExecutor<R,T> {
    /**
     * 业务实现的具体工作接口
     * @param data
     * @return
     */
    ResultInfo<R> executeTask(T data);
}
