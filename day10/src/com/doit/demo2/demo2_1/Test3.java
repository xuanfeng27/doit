package com.doit.demo2.demo2_1;


import com.doit.demo2.Test1;

/**
 * @ClassName: Test3
 * @Author: zll
 * @CreateTime: 2021/6/16 20:15
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        Test1.method1();
        //Test1.method2();
        //Test1.method3();
        //Test1.method4();
    }
}


class Test4 extends Test1{
    public static void main(String[] args) {
        Test1.method1();
        Test1.method2();
        //Test1.method3();
        //Test1.method4();
    }
}