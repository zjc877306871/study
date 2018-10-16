package com.zhangjc.springStudy.chap7.vo;/**
 * Created by user on 2018/10/15.
 */


/**
 * @ClassName Bike
 * @Description TODO
 * @Autor user
 * @Date 2018/10/15 14:37
 * @Version 1.0
 **/
//@Component
public class Bike {
    public Bike() {
        System.out.println("------Bike构造器实例化完成--------");
    }

    public void init(){
        System.out.println("--------init初始化完成---------");
    }

    public void destory(){
        System.out.println("---------destory销毁完成---------");
    }
}
