package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo;/**
 * Created by user on 2018/10/10.
 */

import java.util.List;

/**
 * @ClassName SrcDocsVo
 * @Description  待处理文档实体
 * @Autor user
 * @Date 2018/10/10 16:57
 * @Version 1.0
 **/
public class SrcDocsVo {

    private final String docsName;//文档的名字
    private final List<Integer> questionId;//文档题目的id集合

    public SrcDocsVo(String docsName, List<Integer> questionId) {
        this.docsName = docsName;
        this.questionId = questionId;
    }

    public String getDocsName() {
        return docsName;
    }

    public List<Integer> getQuestionId() {
        return questionId;
    }
}
