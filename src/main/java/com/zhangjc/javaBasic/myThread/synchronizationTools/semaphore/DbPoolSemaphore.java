package com.zhangjc.javaBasic.myThread.synchronizationTools.semaphore;

import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Connection;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * Created by user on 2018/9/5.
 */
public class DbPoolSemaphore {

    private  static final int INIT_SIZE = 10;
    private Semaphore useful;
    private Semaphore useless;

    public DbPoolSemaphore() {
        this.useful = new Semaphore(INIT_SIZE);
        this.useless = new Semaphore(0);
    }

    private static LinkedList<Connection> pool = new LinkedList();
    static {
        for(int i = 0; i < INIT_SIZE; i++){
            pool.addLast(SqlConnectionSevice.fetchConnection());
        }
    }

    /**
     * 获取链接
     * @return
     */
    public Connection getConnection() throws InterruptedException {
            useful.acquire();
            Connection connection = null;
            synchronized (pool){
                connection = pool.removeFirst();
            }
            useless.release();
            return connection;
    }


    /**
     * 释放连接
     */
    public void releaseConnection(Connection connection) throws InterruptedException {
        System.out.println("当前可用连接数"+useful.availablePermits()+"当前等待的连接数"+useful.getQueueLength());
        if(null != connection ){
            useless.acquire();
            synchronized (pool){
                pool.addLast(connection);
            }
            useful.release();
        }
    }
}


