package com.zhangjc.springStudy.chap7.vo;/**
 * Created by user on 2018/10/15.
 */

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName JeepAnntion
 * @Description 可以使用JSR250规则定义的(java规范)两个注解来实现
                    @PostConstruct: 在Bean创建完成,且属于赋值完成后进行初始化,属于JDK规范的注解
                    @PreDestroy: 在bean将被移除之前进行通知, 在容器销毁之前进行清理工作

                    提示: JSR是由JDK提供的一组规范

  * @Autor user
 * @Date 2018/10/15 17:17
 * @Version 1.0
 **/
@Component
public class JeepAnntion {
    public JeepAnntion() {
        System.out.println("----------JeepAnntion---------");
    }


    @PostConstruct
    public void init(){
        System.out.println("-------@PostConstruct-------");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("---------@PreDestroy-------");
    }
}
