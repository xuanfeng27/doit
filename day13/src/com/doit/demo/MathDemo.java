package com.doit.demo;

/**
 * @ClassName: MathDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 9:20
 * @Desc: java 程序
 * @Version: 1.0
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.abs(-4));
        System.out.println(Math.max(12,16));
        System.out.println(Math.min(10,30));
        System.out.println(Math.round(2.4));
        System.out.println(Math.ceil(3.1));//4.0
        System.out.println(Math.floor(3.9));//3.0
        System.out.println(Math.pow(2,4));//16.0
        System.out.println(Math.scalb(9,3));//72.0
        System.out.println(Math.random());//[0,1)
        System.out.println(Math.addExact(10, 3));//13

    }
}
