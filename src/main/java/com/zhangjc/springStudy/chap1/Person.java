package com.zhangjc.springStudy.chap1;/**
 * Created by user on 2018/10/11.
 */

/**
 * @ClassName Person
 * @Description TODO
 * @Autor user
 * @Date 2018/10/11 15:55
 * @Version 1.0
 **/
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("初始化Person对象");
    }

    public Person() {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
