package com.doit.demoObjStream;

import java.io.Serializable;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/7/2 16:02
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
     类似Serializable这种没有任何方法的接口 称为标记型接口

     Serializable就是给一个类打上一个标记,有这个标记就允许序列化 没有这个标记 就不允许序列化


     静态不能序列化
     瞬态不能序列化

    transient:瞬态关键字  阻止成员序列化
 */
public class Person implements Serializable {//允许序列化接口
    private static final long serialVersionUID = 54667710L;//自定义序列号uid
    private String name;
    public  /*static transient*/ int age;//静态和瞬态不可以序列化

    public Person() {
        System.out.println("空参构造执行");
    }

    public Person(String name, int age) {
        System.out.println("带参构造执行");
        this.name = name;
        this.age = age;
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
