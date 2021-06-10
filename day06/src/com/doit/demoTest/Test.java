package com.doit.demoTest;

import com.doit.demo.Person;

/**
 * @ClassName: test
 * @Author: zll
 * @CreateTime: 2021/6/9 9:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    int a;
    public Test() {
        System.out.println("no");
    }

    public Test(int a){
        System.out.println("aaa");
        this.a =a;
    }

    public static void main(String[] args) {
        new Test(3);

        Person p = new Person();
        p.age = 23;
        p.name="zhao";
        p.sex='男';
        System.out.println(p.age);

        Person p2 = new Person();
        p2.age = 33;
        p2.name="li";
        System.out.println(p2.height);
    }

}
