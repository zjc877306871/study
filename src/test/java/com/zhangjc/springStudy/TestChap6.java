
package com.zhangjc.springStudy;
/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap6.config.Chap6Config;
import com.zhangjc.springStudy.chap6.config.ZhangFactoryBean;
import com.zhangjc.springStudy.chap6.config.vo.Self;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestChap1
 * @Description  测试不同的势力注入方式
 * @Autor user
 * @Date 2018/10/11 16:05
 * @Version 1.0
 **/
public class TestChap6 {

    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Chap6Config.class);

        //打印加载到容器的所有bean的名字
        String [] names = app.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        String[] beanNamesForType = app.getBeanNamesForType(ZhangFactoryBean.class);

        for(String name : beanNamesForType){
            System.out.println(name);
        }
        Class<?> factoryBean = app.getBean("factoryBean").getClass();
        System.out.println("容器初始化完成！！！！！！！！！！");

    }
}
