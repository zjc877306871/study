package com.zhangjc.springStudy.chap6.config;/**
 * Created by user on 2018/10/15.
 */

import com.zhangjc.springStudy.chap6.config.vo.Self;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName ZhangFactoryBean
 * @Description
 * @Autor user
 * @Date 2018/10/15 9:42
 * @Version 1.0
 **/
public class ZhangFactoryBean implements FactoryBean<Self>{
    @Override
    public Self getObject() throws Exception {
        return new Self();
    }

    @Override
    public Class<?> getObjectType() {
        return Self.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
