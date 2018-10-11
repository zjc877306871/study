package com.zhangjc.springStudy.chap2.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import com.zhangjc.springStudy.chap2.CostomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import static org.springframework.context.annotation.FilterType.ANNOTATION;
import static org.springframework.context.annotation.FilterType.CUSTOM;

/**
 * @ClassName Chap2Config
 * @Description 使用spring的ComponentScan自动扫描加载  自定义Filter类型
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan(value = "com.zhangjc.springStudy.chap2", includeFilters = {
        @ComponentScan.Filter(type = CUSTOM, classes = CostomFilter.class)
}, useDefaultFilters = false)
public class Chap2Config3 {

    @Bean
    public Person person(){
        return new Person("zhangjc",20);
    }
}
