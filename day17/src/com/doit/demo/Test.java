package com.doit.demo;


/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/25 15:48
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
构造方法摘要
StringBuilder()
          构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
StringBuilder(CharSequence seq)
          构造一个字符串生成器，它包含与指定的 CharSequence 相同的字符。
StringBuilder(int capacity)
          构造一个不带任何字符的字符串生成器，其初始容量由 capacity 参数指定。
StringBuilder(String str)
          构造一个字符串生成器，并初始化为指定的字符串内容。

 */
public class Test{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("aaa");
        sb.append("").reverse().delete(0,1).substring(0).replace("b","d");
        //.concat("6").trim().toLowerCase().compareTo("44").getBytes().split("-")indexOf("b");
    }
}
