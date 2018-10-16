package com.zhangjc.springStudy.chap7.vo;/**
 * Created by user on 2018/10/15.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName JeepLife
 * @Description bean的后 置处理器,在bean初始化之前调用进行拦截,在bean初始化前后进行一些处理工作
    使用BeanPostProcessors如何控制Bean的生命周期;

 * @Autor user
 * @Date 2018/10/15 17:20
 * @Version 1.0
 **/
@Component
public class JeepLife implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------postProcessBeforeInitialization-----" + beanName);
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------postProcessAfterInitialization-----" + beanName);
        return null;
    }
}
