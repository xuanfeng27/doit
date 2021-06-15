package com.doit.demo2;

/**
 * @ClassName: UseKeywords
 * @Author: zll
 * @CreateTime: 2021/6/15 14:51
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
public 公共权限 可以修饰类 方法 成员变量
 */
public abstract class UseKeywords {

    public final static double PI = 3.14;

    //private abstract void method(); private无法继承不能与abstract一起使用

    //public final abstract void method2(); final无法重写不能与abstract一起使用

    //public static abstract void method3();//staitic可以用类名.方法名使用（没有方法体，无意义）不能与abstract一起用


}
