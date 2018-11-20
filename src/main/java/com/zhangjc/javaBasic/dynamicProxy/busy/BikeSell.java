package com.zhangjc.javaBasic.dynamicProxy.busy;/**
 * Created by zjc on 2018/11/20.
 */

/**
 * 描述:
 *
 * @author zjc
 * @create 2018-11-20 21:06
 */

public class BikeSell implements CommonSell{

    @Override
    public void sell() {
        System.out.println("BikeSell======================");
    }
}