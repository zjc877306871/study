package com.zhangjc.springStudy.chap10.config;/**
 * Created by user on 2018/10/18.
 */

import com.zhangjc.springStudy.chap10.aop.BeanAopHandle;
import com.zhangjc.springStudy.chap10.bean.BookAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName ConfigMain10
 * @Description TODO
 * @Autor user
 * @Date 2018/10/18 11:34
 * @Version 1.0
 **/
@Configuration
@EnableAspectJAutoProxy
public class Chap10Config {

    @Bean
    public BeanAopHandle beanAopHandle(){
        return new BeanAopHandle();
    }

    @Bean
    public BookAop bookAop(){
        return new BookAop();
    }
}
