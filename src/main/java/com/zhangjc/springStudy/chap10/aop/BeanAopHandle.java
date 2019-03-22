package com.zhangjc.springStudy.chap10.aop;/**
 * Created by user on 2018/10/18.
 */


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @ClassName BeanAopHandle
 * @Description TODO
 * @Autor user
 * @Date 2018/10/18 11:17
 * @Version 1.0
 **/
@Aspect
public class BeanAopHandle {

    @Before(value = "execution(public int com.zhangjc.springStudy.chap10.bean.*.*(..))")
    public void before(){
        System.out.println("--------before------");
    }


    @After(value = "execution(public int com.zhangjc.springStudy.chap10.bean.*.*(..))")
    public void after(){
        System.out.println("--------after------");
    }
}
