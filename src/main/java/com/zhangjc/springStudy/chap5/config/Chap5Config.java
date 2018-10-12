package com.zhangjc.springStudy.chap5.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Chap2Config
 * @Description 通过condition接口选择性注入某一个实例到spring容器中
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
public class Chap5Config {

    @Bean
    public Person person(){
        return new Person("zhangjc",20);
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public Person lisi(){
        return new Person("lisi",20);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person wangwu(){
        return new Person("wangwu",20);
    }


}
