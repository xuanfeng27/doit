package com.doit.constructor;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/12 11:49
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    String a = "superclass string";
    private String name;
    private int age;


    public Person() {
        System.out.println("Person 空参构造");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person 满参构造");
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

    public void testSup(){
        System.out.println("supclass func");
    }
}
