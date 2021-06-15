package com.doit.demo2;

/**
 * @ClassName: Test2
 * @Author: zll
 * @CreateTime: 2021/6/15 15:02
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test2 {

    public static void main(String[] args) {
        Test1.method1();
        Test1.method2();
        Test1.method3();
        //Test1.method4();
    }
}


class Test3 extends Test1{
    public static void main(String[] args) {
        method1();
        method2();
        method3();
       // method4();
    }
}