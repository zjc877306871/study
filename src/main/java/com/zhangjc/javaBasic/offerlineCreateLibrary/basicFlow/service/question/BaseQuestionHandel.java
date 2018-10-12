package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.service.question;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.BussinessSql;

import java.util.Random;

/**
 * @ClassName BaseQuestionHandel
 * @Description 单个题目的处理器，可以看成DAO层
 * @Autor user
 * @Date 2018/10/11 20:42
 * @Version 1.0
 **/
public class BaseQuestionHandel {

    public static String makeQuestion(Integer questionId, String questionSrc){

        Random random = new Random();
        BussinessSql.business(450 + random.nextInt(100));
        return "CompleteQuestion[id=" + questionId + " content=" + questionSrc + "]";
    }
}
