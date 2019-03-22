package com.zhangjc.javaBasic.myThread;/**
 * Created by user on 2019/3/5.
 */

/**
 * @ClassName JmmDemo
 * @Description TODO
 * @Autor user
 * @Date 2019/3/5 16:06
 * @Version 1.0
 **/
public class JmmDemo {

    private final String name;
    private String newName;

    private final int number;
    public JmmDemo(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public  void change(){
        newName = name;
        System.out.println(newName);

    }


    public static void main(String[] args) {
        JmmDemo jmmDemo = new JmmDemo("2222",999);
        jmmDemo.change();
    }
}
