package com.doit.bean;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/7/6 10:47
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;

    static {
        System.out.println("Person 类初始化了");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    private void eat(){}
}
