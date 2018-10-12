package com.zhangjc.springStudy.chap6.config;/**
 * Created by user on 2018/10/12.
 */

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName ZhangImportSelector
 * @Description TODO
 * @Autor user
 * @Date 2018/10/12 16:57
 * @Version 1.0
 **/
public class ZhangImportSelector implements ImportSelector{

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //不能直接return null;会报空指针错误，需要注入什么类，直接将类全名写入数组就好
        return new String[]{
                "com.zhangjc.springStudy.chap6.config.vo.Tiger","com.zhangjc.springStudy.chap6.config.vo.Rubbiter"
        };
    }
}
