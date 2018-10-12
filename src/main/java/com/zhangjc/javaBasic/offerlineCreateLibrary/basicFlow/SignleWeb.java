package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.CreatePendingDocs;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.HandleQuestionBnak;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.service.ProduceDocService;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo.SrcDocsVo;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SignleWeb
 * @Description TODO
 * @Autor user
 * @Date 2018/10/11 21:16
 * @Version 1.0
 **/
public class SignleWeb {
    public static void main(String[] args) {
        System.out.println("题库开始初始化。。。。。。。");
        HandleQuestionBnak.initBank();
        System.out.println("题库初始化完成。");

        //创建两个待处理文档
        List<SrcDocsVo> docList = CreatePendingDocs.makePendingDocs(2);
        long startTime = System.currentTimeMillis();
        for(SrcDocsVo srcDocsVo : docList){
            System.out.println("开始处理文档： " + srcDocsVo.getDocsName());
            long start = System.currentTimeMillis();
            String localName = ProduceDocService.makeDoc(srcDocsVo);
            System.out.println("文档" + localName + "生成耗时： " +
                    (System.currentTimeMillis()-start) + "ms");
            start = System.currentTimeMillis();
            String uploadName = ProduceDocService.uploadDoc(localName);
            System.out.println("文档上传至" + uploadName + "上传耗时： " +
                    (System.currentTimeMillis()-start) + "ms");
        }
        System.out.println("------------共耗时："
                +(System.currentTimeMillis()-startTime)+"ms-------------");
    }
}
