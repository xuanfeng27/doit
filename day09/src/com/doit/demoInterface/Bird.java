package com.doit.demoInterface;

/**
 * @ClassName: Bird
 * @Author: zll
 * @CreateTime: 2021/6/14 10:40
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Bird implements Fly {

    @Override
    public void method() {

    }

    @Override
    public void open() {
        System.out.println("bird open");
    }

    @Override
    public void fly() {
        System.out.println("bird fly");
    }

    @Override
    public void close() {
        System.out.println("bird close");
    }
}
