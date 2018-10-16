package com.zhangjc.springStudy.chap8.dao;/**
 * Created by user on 2018/10/16.
 */

import org.springframework.stereotype.Repository;

/**
 * @ClassName CarDao
 * @Description TODO
 * @Autor user
 * @Date 2018/10/16 11:11
 * @Version 1.0
 **/
@Repository
public class CarDao {
    private String color = "1";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarDao{" +
                "color='" + color + '\'' +
                '}';
    }
}
