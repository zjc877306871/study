package com.zhangjc.javaBasic.queue.entry;

/**
 * Created by user on 2018/9/19.
 */
public class People implements Comparable<People>{

    private String name;
    private int age;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public int compareTo(People o) {
        return this.age > o.getAge() ? 1 : (this.age < o.getAge() ? -1 : 0) ;
    }
}
