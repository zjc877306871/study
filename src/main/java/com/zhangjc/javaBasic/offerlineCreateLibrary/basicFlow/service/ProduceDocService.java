package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.service;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.service.question.SingleQstService;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.BussinessSql;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo.SrcDocsVo;

import java.util.Random;

/**
 * @ClassName ProduceDocService
 * @Description 处理文档的服务，包括文档中题目的处理和文档生成后的上传
 * @Autor user
 * @Date 2018/10/11 21:01
 * @Version 1.0
 **/
public class ProduceDocService {

    /**
     * 上传文档到网络
     * @param docFileName   实际文档在本地的位置
     * @return  上传后的网络储存位置
     */
    public static String uploadDoc(String docFileName){
        Random random = new Random();
        BussinessSql.business(9000 + random.nextInt(400));
        return "http://www.xxxx.com/file/upload/"+docFileName;
    }

    /**
     * 将待处理文档处理为本地实际的pdf文档
     * @param srcDocsVo  待处理文档
     * @return 实际文档在本地的储存位置
     */
    public static String makeDoc(SrcDocsVo srcDocsVo){

        System.out.println("开始处理文档： " + srcDocsVo.getDocsName());
        StringBuffer stringBuffer = new StringBuffer();
        //循环处理文档中的每个题目
        for(Integer questionId : srcDocsVo.getQuestionId()){
            stringBuffer.append(SingleQstService.makeQuestion(questionId));
        }
        return "complete_" + System.currentTimeMillis() + "_" + srcDocsVo.getDocsName()
                + ".pdf";
    }
}


