package com.doit.demo;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/11 9:36
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    int age;
    String name;
    String adress;

    public void eat(){
        System.out.println(name + " eat");
    }
    public void sleep(){
        System.out.println(age + " sleep");
    }
    public void hitBean(){
        System.out.println("hitBean "+name +age);
    }

}
