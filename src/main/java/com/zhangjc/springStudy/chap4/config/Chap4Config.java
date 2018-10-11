package com.zhangjc.springStudy.chap4.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import org.springframework.context.annotation.*;

/**
 * @ClassName Chap2Config
 * @Description @Lazy 值针对单实例才会有延迟加载
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan(value = "com.zhangjc.springStudy.chap3")
public class Chap4Config {

    @Bean
//    @Lazy
    public Person person(){
        return new Person("zhangjc",20);
    }
}
