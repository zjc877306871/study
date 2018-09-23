package com.zhangjc.javaBasic.batchFramework;/**
 * Created by zjc on 2018/9/23.
 */

/**
 * 描述:
 *
 * @author zjc
 * @create 2018-09-23 12:53
 */

public class ResultInfo<R> {
    private ResultType type;
    private R resultVale;
    private String reason;

    /**
     * 普通情况的构造函数
     * @param type
     * @param resultVale
     * @param reason
     */
    public ResultInfo(ResultType type, R resultVale, String reason) {
        this.type = type;
        this.resultVale = resultVale;
        this.reason = reason;
    }

    /**
     * 成功状态时构造函数
     * @param type
     * @param resultVale
     */
    public ResultInfo(ResultType type, R resultVale) {
        this.type = type;
        this.resultVale = resultVale;
        this.reason = "SUCCESS";
    }

    public ResultType getType() {
        return type;
    }

    public R getResultVale() {
        return resultVale;
    }

    public String getReason() {
        return reason;
    }
}