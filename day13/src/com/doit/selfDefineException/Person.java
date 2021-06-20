package com.doit.selfDefineException;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/20 17:16
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
        if (age < 0||age > 150) {
            throw new AgeOutOfBoundsException("年龄超标了"+age);
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
