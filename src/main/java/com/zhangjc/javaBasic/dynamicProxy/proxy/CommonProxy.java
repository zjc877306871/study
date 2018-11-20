package com.zhangjc.javaBasic.dynamicProxy.proxy;/**
 * Created by zjc on 2018/11/20.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author zjc
 * @create 2018-11-20 21:09
 */

public class CommonProxy implements InvocationHandler {

    private Object object;

    public CommonProxy(Object object) {
        this.object = object;
    }



    //获取代理对象的方法
    public Object insanceProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------------");
        return method.invoke(object,args);
    }
}