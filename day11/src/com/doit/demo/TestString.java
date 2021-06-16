package com.doit.demo;

/**
 * @ClassName: TestString
 * @Author: zll
 * @CreateTime: 2021/6/15 19:43
 * @Desc: java 程序
 * @Version: 1.0
 */

public class TestString {
    public static void main(String[] args) {
        //构造方法的方式得到对象
        char[] chs = {'a', 'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        //直接赋值的方式得到对象
        String s3 = "abc";
        String s4 = "abc";

        //比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("--------");

        //比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}

class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();

        StringBuilder sb2 = sb.append("hello");

        System.out.println("sb:" + sb);//hello
        System.out.println("sb2:" + sb2);//hello
        System.out.println(sb == sb2);//true

    }
}

class Changliang {
    public static void main(String[] args) {
        // s1与s2是相等的，为字节码常量
        String s1 = "abc";
        String s2 = "abc";

        // s3创建在堆内存中
        String s3 = new String("abc");

        // intern方法可以将对象变为运行时常量
        // intern是一个native方法
        System.out.println(s1 == s3.intern()); // true
    }
}
