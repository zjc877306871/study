package com.zhangjc.springStudy.chap2;/**
 * Created by user on 2018/10/11.
 */

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @ClassName CostomFilter
 * @Description TODO
 * @Autor user
 * @Date 2018/10/11 16:55
 * @Version 1.0
 **/
public class CostomFilter implements TypeFilter {

    /**
     *
     * @param metadataReader:读取到当前正在扫描类的信息
     * @param metadataReaderFactory:可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取类注解的元数据
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取类的元数据
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取类的资源路径
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("----->"+className);
        if(className.contains("ss")){
            return true;
        }
        return false;
    }
}
