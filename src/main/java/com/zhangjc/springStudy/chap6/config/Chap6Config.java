package com.zhangjc.springStudy.chap6.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import com.zhangjc.springStudy.chap5.config.LinuxCondition;
import com.zhangjc.springStudy.chap5.config.WindowsCondition;
import com.zhangjc.springStudy.chap6.config.vo.Cat;
import com.zhangjc.springStudy.chap6.config.vo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName Chap6Config
 * @Description 更多的注入实例的方式
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@Import(value = {Cat.class, Dog.class, ZhangImportSelector.class, ZhangImportRegister.class})
public class Chap6Config {

    /**
     * 1/ 常用的@Bean注解实现实例注入
     * 2、使用@Import直接
     *      使用ImportSelector 接口自定义筛选条件
     *      使用ImportBeanDefinitionRegistrar
     *
     */

    @Bean
    public Person person(){
        return new Person("zhangjc",20);
    }

}
