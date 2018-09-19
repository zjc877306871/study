package com.zhangjc.javaBasic.threadPool.scheduled;

/**
 * Created by user on 2018/9/18.
 */
public class ScheduledExceptionHandle implements Runnable{
    private String flage;

    public ScheduledExceptionHandle(String flage) {
        this.flage = flage;
    }

    public static final String NOMER = "0";
    public static final String EXCEPTION_HANDLE = "1";
    public static final String NO_EXCEPTION_HANDLE = "2";


    @Override
    public void run() {
        if(EXCEPTION_HANDLE == flage){
            try {
                System.out.println("处理  EXCEPTION_HANDLE");
                throw new RuntimeException("EXCEPTION_HANDLE Happen");
            } catch (RuntimeException e) {
                System.out.println("catch 处理  EXCEPTION_HANDLE");
            }
        }else if(NO_EXCEPTION_HANDLE == "2"){
            System.out.println("NO_EXCEPTION_HANDLE");
            throw new RuntimeException("NO_EXCEPTION_HANDLE Happen");

        }else{
            System.out.println("nomer");
        }
    }



}
