package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow;/**
 * Created by user on 2018/10/10.
 */

import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.constant.Constants;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo.QuestionInDBVo;
import com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo.SrcDocsVo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CreatePendingDocs
 * @Description 生成待处理的文档
 * @Autor user
 * @Date 2018/10/10 16:55
 * @Version 1.0
 **/
public class CreatePendingDocs {

    public static List<SrcDocsVo> makePendingDocs(int count){
        Random random = new Random();
        //文档列表
        List<SrcDocsVo> list = new LinkedList<>();
        for(int i=0; i<count; i++){
            List<Integer> questionInDBVoList = new LinkedList<>();
            for(int j=0; j< Constants.QUESTION_COUNT_IN_WORD; j++){
                int questionId = random.nextInt(Constants.SIZE_QUESTION_LIBRARY);
                questionInDBVoList.add(questionId);
            }
            SrcDocsVo srcDocsVo = new SrcDocsVo("pending_"+i,
                    questionInDBVoList);
            list.add(srcDocsVo);

        }
        return list;
    }

}
