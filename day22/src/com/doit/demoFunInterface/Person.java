package com.doit.demoFunInterface;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/7/3 15:47
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
