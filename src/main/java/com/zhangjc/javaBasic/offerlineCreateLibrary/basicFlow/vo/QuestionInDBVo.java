package com.zhangjc.javaBasic.offerlineCreateLibrary.basicFlow.vo;/**
 * Created by user on 2018/10/10.
 */

/**
 * @ClassName QuestionInDBVo
 * @Description TODO
 * @Autor user
 * @Date 2018/10/10 15:49
 * @Version 1.0
 **/
public class QuestionInDBVo {
    private final int id;

    private final String detail;

    public QuestionInDBVo(int id, String detail) {
        this.id = id;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }
}
