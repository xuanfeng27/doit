package com.doit.demo2;

/**
 * @ClassName: Test1
 * @Author: zll
 * @CreateTime: 2021/6/15 14:59
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test1 {

    public static void method1(){
        System.out.println("public method1");
    }

    protected static void method2(){
        System.out.println("protected method2");
    }

    static void method3(){
        System.out.println("default package method3");
    }

    private static void method4(){
        System.out.println("private method4");
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }
}
