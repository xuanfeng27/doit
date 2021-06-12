package com.doit.demo;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/12 9:31
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
