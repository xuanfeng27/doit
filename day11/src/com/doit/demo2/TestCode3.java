package com.doit.demo2;

/**
 * @ClassName: TestCode3
 * @Author: zll
 * @CreateTime: 2021/6/17 20:45
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
 统计一个字符串中 出现小字符串的次数
    比如  abcaaaccccabcbbbbabcllllabcabc  这个字符串中 abc出现的次数
    三种方式
         第一种思路
             通过indexof方法 获取到小串出现的索引 如果返回出现的不是-1
             就通过 索引+小串的长度 将字符串进行截取
             截取出现的新串 继续获取 小串的索引 直到-1
             abcaaaccccabcbbbbabcllllabc  第一次 从整个字符串中获取 abc出现的索引
             aaaccccabcbbbbabcllllabc   将整个字符串进行截取 在截取出现的新串中 继续获取abc出现的索引
            bbbbabcllllabc  继续截取 继续获取 直到 返回-1

         第二种思路
             和第一种思路类似 第一次从大串中找
             第二次从字符串的后面中找 直到找不到为止 返回-1

         第三种思路 最简单
             abcaaaccccabcbbbbabcllllabcabc  将大串中的abc 全部替换为""
             获取原来字符串的长度  -  替换后字符串的长度 =  abc出现的总长度
             次数 = 总长度/字符串的长度
 */
public class TestCode3 {
    public static void main(String[] args) {
        String str = "abcaaaccccabcbbbbabcllllabcabc";
        int num = searchStr(str);
        System.out.println(num);
    }

    public static int searchStr(String str){
        String s = "abc";
        int num =0;
        while (true){
            if(!str.contains(s)){
                return num;
            }
            int index =  str.indexOf(s);
            str = str.substring(index + s.length());
            num++;
        }
    }

    public static int searchStr1(String str){
        int num = 0;
        String s1 = "abc";
        String newStr = str.replaceAll(s1,"");
        num = (str.length() - newStr.length())/s1.length();
        return num;
    }
}
