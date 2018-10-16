package com.zhangjc.springStudy.chap7.vo;/**
 * Created by user on 2018/10/15.
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName JeepProcess
 * @Description 1, 实现InitializingBean接口的afterPropertiesSet()方法,当beanFactory创建好对象,
 *              且把bean所有属性设置好之后,会调这个方法,相当于初始化方法
 *               2, 实现DisposableBean的destory()方法,当bean销毁时,会把单实例bean进行销毁
 * @Autor user
 * @Date 2018/10/15 17:12
 * @Version 1.0
 **/
@Component
public class JeepProcess implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("-------DisposableBean---------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-------InitializingBean---------");
    }
}
