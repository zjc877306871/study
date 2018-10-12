package com.zhangjc.springStudy.chap6.config;/**
 * Created by user on 2018/10/12.
 */

import com.zhangjc.springStudy.chap6.config.vo.Pig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName ZhangImportRegister
 * @Description TODO
 * @Autor user
 * @Date 2018/10/12 17:16
 * @Version 1.0
 **/
public class ZhangImportRegister implements ImportBeanDefinitionRegistrar {

    /**
     * 当容器中已经存在 cat dog  实例时才注入Pig,
     * @param annotationMetadata  类上注解 的元数据
     * @param beanDefinitionRegistry  注册bean实例的注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        //ioc容器中是否包含cat实例
        boolean cat = beanDefinitionRegistry.containsBeanDefinition("com.zhangjc.springStudy.chap6.config.vo.Cat");
        boolean dog = beanDefinitionRegistry.containsBeanDefinition("com.zhangjc.springStudy.chap6.config.vo.Dog");
        if(cat && dog){
            //将需要注册时实例用RootBeanDefinition进行封装
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            beanDefinitionRegistry.registerBeanDefinition("pig", beanDefinition);
        }

    }
}
