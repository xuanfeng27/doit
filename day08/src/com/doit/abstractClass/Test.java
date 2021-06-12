package com.doit.abstractClass;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/12 17:20
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.work();
        t.setAge(22);
        System.out.println(t.getAge());


    }
}
