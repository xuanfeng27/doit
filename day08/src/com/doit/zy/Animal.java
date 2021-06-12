package com.doit.zy;

/**
 * @ClassName: Animal
 * @Author: zll
 * @CreateTime: 2021/6/12 19:51
 * @Desc: java 程序
 * @Version: 1.0
 */
public abstract class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void sleep();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
