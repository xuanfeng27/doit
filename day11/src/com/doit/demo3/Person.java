package com.doit.demo3;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/18 15:15
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("来啊，垃圾回收器");
        super.finalize();
    }
}
