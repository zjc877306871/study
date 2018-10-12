package com.zhangjc.springStudy.chap5.config;/**
 * Created by user on 2018/10/12.
 */

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName LinuxCondition
 * @Description  选择性注入实例，linux系统下注入wangwu实例
 * @Autor user
 * @Date 2018/10/12 16:29
 * @Version 1.0
 **/
public class LinuxCondition implements Condition{
    /**
     *
     * @param conditionContext  上下文环境
     * @param annotatedTypeMetadata  该类上的所有注解的元数据
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //通过上下文环境获取bean工厂，可以获取到所有注册到容器里面的bean实例
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取运行系统
        Environment environment = conditionContext.getEnvironment();
        String os_name = environment.getProperty("os.name");
        if(os_name.contains("Linux")){
            return true;
        }

        return false;
    }
}
