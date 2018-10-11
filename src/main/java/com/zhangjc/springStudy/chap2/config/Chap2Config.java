package com.zhangjc.springStudy.chap2.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Chap2Config
 * @Description TODO
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan
public class Chap2Config {

    @Bean
    public Person person(){
        return new Person("zhangjc",20);
    }
}
