package com.zhangjc.springStudy.chap10.bean;/**
 * Created by user on 2018/10/18.
 */

/**
 * @ClassName BookAop
 * @Description TODO
 * @Autor user
 * @Date 2018/10/18 11:14
 * @Version 1.0
 **/

public class BookAop {

    public int read(int i, int j){
        System.out.println("--------read---------");
        return i/j;
    }
}
