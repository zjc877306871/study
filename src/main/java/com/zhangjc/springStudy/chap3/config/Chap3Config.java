package com.zhangjc.springStudy.chap3.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName Chap2Config
 * @Description 使用spring的@Scope//默认是单实例,
 * @Scope("prototype")  为多实例，当调用该对象时才会初始化该对象实例
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan(value = "com.zhangjc.springStudy.chap3")
public class Chap3Config {

    @Bean
    @Scope("prototype")
    public Person person(){
        return new Person("zhangjc",20);
    }
}
