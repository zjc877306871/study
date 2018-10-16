package com.zhangjc.springStudy.chap7.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import com.zhangjc.springStudy.chap6.config.ZhangFactoryBean;
import com.zhangjc.springStudy.chap6.config.ZhangImportRegister;
import com.zhangjc.springStudy.chap6.config.ZhangImportSelector;
import com.zhangjc.springStudy.chap6.config.vo.Cat;
import com.zhangjc.springStudy.chap6.config.vo.Dog;
import com.zhangjc.springStudy.chap7.vo.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName Chap6Config
 * @Description  探讨bean 的生命周期。构造器创建bean---->init初始化bean------->destroy方法对bean实例进行销毁
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.zhangjc.springStudy.chap7")
public class Chap7Config {

    @Bean
    public Person person(){
        return new Person("zhangjc",20);
    }


    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bike bike(){
        return new Bike();
    }
}
