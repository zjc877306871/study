package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist;/**
 * Created by user on 2018/10/10.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.constant.Constants;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.assist.BussinessSql;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo.QuestionInDBVo;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HandleQuestionBnak
 * @Description   模拟储存在数据库中的题库数据
 * @Autor user
 * @Date 2018/10/10 15:44
 * @Version 1.0
 **/
public class HandleQuestionBnak {

    //储存题库数据，key就是 题目 的id,value是题目的内容详情
    private static ConcurrentHashMap<Integer,QuestionInDBVo> questionMap =
            new ConcurrentHashMap<>();

    //定时任务，负责定时更新题库数据
    private static ScheduledExecutorService updateQuestion =
            new ScheduledThreadPoolExecutor(1);

    //初始化题库
    public static void initBank(){
        for(int i=0; i< Constants.SIZE_QUESTION_LIBRARY; i++){
            String questionContent = makeQuestionDetail(Constants.LENGTH_QUESTION);
            questionMap.put(i,new QuestionInDBVo(i,questionContent));
        }
        updateQuestionTimer();
    }

    //生成随机数，模拟生成题目内容
    public static String makeQuestionDetail(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<length; i++){
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }

    private static class UpdateBank implements Runnable{

        @Override
        public void run() {
            //随机数
            Random random = new Random();
            int questionId = random.nextInt(Constants.SIZE_QUESTION_LIBRARY);
            String questionContent = makeQuestionDetail(Constants.LENGTH_QUESTION);
            questionMap.put(questionId,new QuestionInDBVo(questionId,questionContent));
            System.out.println("题目【"+questionId+"】被更新！！");
        }
    }

    public static void updateQuestionTimer(){
        System.out.println("开始定时更新题库..........................");
        updateQuestion.scheduleAtFixedRate(new UpdateBank(),15,5, TimeUnit.SECONDS);
    }

    //获取题目，假设一次数据库的读消耗一般在20ms
    public static QuestionInDBVo getQuestion(int i){
        BussinessSql.business(20);
        return questionMap.get(i);
    }
}
