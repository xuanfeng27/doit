package com.doit.abstractClass;

/**
 * @ClassName: Teacher
 * @Author: zll
 * @CreateTime: 2021/6/12 17:17
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Teacher extends AbstractClass {
    @Override
    public AbstractClass work() {
        System.out.println("teacher work");
        return null;
    }
}
