package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.service.question;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.HandleQuestionBnak;

/**
 * @ClassName SingleQstService
 * @Description 类说明：调用单个题目的处理器对题目进行处理的服务实现
 * @Autor user
 * @Date 2018/10/11 20:47
 * @Version 1.0
 **/
public class SingleQstService {

    public static String makeQuestion(Integer questionId){
        return BaseQuestionHandel.makeQuestion(questionId,
                HandleQuestionBnak.getQuestion(questionId).getDetail());
    }
}
