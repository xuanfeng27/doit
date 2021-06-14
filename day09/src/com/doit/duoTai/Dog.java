package com.doit.duoTai;

/**
 * @ClassName: Dog
 * @Author: zll
 * @CreateTime: 2021/6/14 9:49
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Dog extends Animal implements HomeKeeper{
    @Override
    public void  eat() {
        System.out.println("dog eat");
    }

    @Override
    public void sleep() {
        System.out.println("dog sleep");
    }

    @Override
    public void lookHome() {
        System.out.println("dog lookhome");
    }
}
