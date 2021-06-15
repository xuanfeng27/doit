package com.doit.demo;

/**
 * @ClassName: StaticTest
 * @Author: zll
 * @CreateTime: 2021/6/15 9:37
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
 **被static修饰的成员变量属于类，不属于这个类的某个对象,即多个对象共享同一个static成员变量
 * 静态内容是优先于对象存在，只能访问静态，不能使用this/super。静态修饰的内容存于静态区。
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
        StaticTest.method();
        t.a =0;//不推荐

        StaticTest t2 = new StaticTest();
        System.out.println(t2.a);
    }

    public static void method(){
        System.out.println(" static method");
    }

    public void method2(){
        System.out.println(a);
    }
}

