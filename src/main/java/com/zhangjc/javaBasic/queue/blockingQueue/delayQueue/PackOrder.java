package com.zhangjc.javaBasic.queue.blockingQueue.delayQueue;/**
 * Created by user on 2018/9/20.
 */

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PackOrder
 * @Description 存放到队列的元素
 * @Autor user
 * @Date 2018/9/20 15:35
 * @Version 1.0
 **/
public class PackOrder<T> implements Delayed{

    private long activeTime;
    private T date;


    //activeTime 是过期时长
    public PackOrder(long activeTime, T date) {
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime,TimeUnit.MILLISECONDS) +
                        System.nanoTime();
        this.date = date;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public T getDate() {
        return date;
    }

    //还剩多少延长时间
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.NANOSECONDS.convert(this.activeTime - System.nanoTime(),
                TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long d  = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return d == 0 ? 0 : (d > 0 ? 1 : -1);
    }

}
