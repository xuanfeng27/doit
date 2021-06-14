package com.doit.duoTai;

/**
 * @ClassName: Cat
 * @Author: zll
 * @CreateTime: 2021/6/14 9:50
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void sleep() {
        System.out.println("cat sleep");
    }
}
