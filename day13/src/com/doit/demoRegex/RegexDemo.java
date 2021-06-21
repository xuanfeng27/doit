package com.doit.demoRegex;


/**
 * @ClassName: RegexDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 18:57
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
    [ ]    括号中的内容 任选其一
    [^ ]   除了括号中的内容 都行

    ?   0-1次
    *   任意次
    +   至少1次

    {n} 恰好n次
    {n,} 至少n次
    {n,m} n-m次  包含n 包含m


    [a-zA-Z_0-9]  字母 数字 _ 我们称为 单词字符

    其他字符 称为单词边界

正则规则-字符类
| 规则写法        | 规则含义
| ----------- | --------------------------
| [abc]       | a或 b 或 c
| [^abc]      | 除了 a、b 、c（否定）
| [a-zA-Z]    | a 到 z 或 A到 Z，两头的字母包括在内（范围）
| [0-9]       | 0到 9，两头的数字包括在内（范围）
| [a-zA-Z0-9] | a 到 z 或 A到 Z或0-9

正则规则-预定义字符类

| 规则写法 | 规则含义
| ---- | --------------------
| .    | 任何字符
| \d   | 数字[0-9]
| \D   | 非数字 `[^0-9]`
| \w   | 单词字符 [a-zA-Z0-9_]
| \W   | 非单词字符`[^a-zA-Z0-9_]` 单词边界

正则规则-数量词

| 规则写法   | 规则含义
| ------ | --------------------
| X{?}   | 1次或0次
| X{*}   | 零次及以上
| X{+}   | 一次及以上
| X{n}   | 恰好 n次
| X{n,}  | 至少 n次
| X{n,m} | 至少 n次，不超过 m次
 */

public class RegexDemo {
    public static void main(String[] args) {
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+";
        String mail = "fsd34ff@fs.doit.com.cn";
        boolean bool = mail.matches(regex);
        System.out.println(bool);//true

       // "[1-9][0-9]{4,10}" 长度 5-11位 且 0不能开头 且 纯数字

        String s1 = "重地";
        String s2 = "通话";
        System.out.println(s1.hashCode() == s2.hashCode());//true
    }
}
