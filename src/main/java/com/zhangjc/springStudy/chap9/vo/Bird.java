package com.zhangjc.springStudy.chap9.vo;/**
 * Created by user on 2018/10/16.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @ClassName Bird
 * @Description TODO
 * @Autor user
 * @Date 2018/10/16 14:51
 * @Version 1.0
 **/

public class Bird {
    @Value("zhangjc")
    private String name;
    @Value("#{20-2}")//el表达式
    private int age;
    @Value("${bird.color}")///${}获取配置文件的值
    private String color;

    public Bird() {
    }

    public Bird(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
