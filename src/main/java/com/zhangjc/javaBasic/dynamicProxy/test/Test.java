package com.zhangjc.javaBasic.dynamicProxy.test;/**
 * Created by zjc on 2018/11/20.
 */

import com.zhangjc.javaBasic.dynamicProxy.busy.BikeSell;
import com.zhangjc.javaBasic.dynamicProxy.busy.CommonSell;
import com.zhangjc.javaBasic.dynamicProxy.proxy.CommonProxy;

/**
 * 描述:
 *
 * @author zjc
 * @create 2018-11-20 21:14
 */

public class Test {


    public static void main(String[] args) {
        CommonSell commonSell = new BikeSell();

        CommonProxy proxy = new CommonProxy(commonSell);
        CommonSell bike = (CommonSell) proxy.insanceProxy();
        bike.sell();


    }
}