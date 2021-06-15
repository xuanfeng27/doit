package com.doit.demo;

/**
 * @ClassName: StaticTest
 * @Author: zll
 * @CreateTime: 2021/6/15 9:37
 * @Desc: java 程序
 * @Version: 1.0
 */
public class StaticTest {
    int age = 13;
    String name = "mi";
    static int a = 3;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(StaticTest.a);//推荐 类名.属性名

        StaticTest t = new StaticTest();
        System.out.println(t.age);
        t.method();
        t.a =0;//不推荐

        StaticTest t2 = new StaticTest();
        System.out.println(t2.a);
    }

    public void method(){
        System.out.println("not static method");
    }

    public void method2(){
        System.out.println(a);
    }
}

