package com.doit.demo;

/**
 * @ClassName: PhoneTest
 * @Author: zll
 * @CreateTime: 2021/6/11 10:39
 * @Desc: java 程序
 * @Version: 1.0
 */
public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.setAttr("xiaomi","red",1999);
        p1.show();

        Phone p2 = new Phone();
        p2.show();
    }
}
