package com.doit.abstractClass;

/**
 * @ClassName: Manager
 * @Author: zll
 * @CreateTime: 2021/6/12 17:19
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Manager extends AbstractClass {
    @Override
    public AbstractClass work() {
        System.out.println("manager work");
        return null;
    }
}
