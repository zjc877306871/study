package com.zhangjc.springStudy;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestChap1
 * @Description 通过最基本的通过配置文件来加载bean到ioc容器。
 * @Autor user
 * @Date 2018/10/11 16:05
 * @Version 1.0
 **/
public class TestChap1 {

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        Person person = (Person) app.getBean("person");
        System.out.println(person);
    }
}
