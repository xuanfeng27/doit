package com.doit.demo1;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/**
 * @ClassName: StringDemo
 * @Author: zll
 * @CreateTime: 2021/6/17 14:55
 * @Desc: java 程序
 * @Version: 1.0
 */
//字符串是常量；它们的值在创建之后不能更改。字符串缓冲区支持可变的字符串。因为 String 对象是不可变的，所以可以共享。例如：
//     String str = "abc";等效于：
//     char data[] = {'a', 'b', 'c'}; String str = new String(data);
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "abc";//常量池0x1111
        a = "bcd";//常量池0x2222
        String b = "bcd";//常量池0x2222
        String c = new String("abc");//堆内存地址0x3333存放地址值0x1111指向常量池中"abc"
        System.out.println(a==b);

        //构造函数public String(char[] chs){}将字符数组转为字符串；
        //构造函数public String(char[] chs,int start,int length){}
        char[] chs = new char[]{'a','b','c','d'};
        String str = new String(chs);
        System.out.println(str);//abcd
        String str1 = new String(chs,0,2);
        System.out.println(str1);//ab
        //构造函数public String(byte[] byt){}将字节数组转为字符串；
        byte[] byt = new byte[]{65,66,67,68};
        String str2 = new String(byt);
        System.out.println(str2);//ABCD 解码

        //String.toCharArray()字符串转为字符数组
        char[] chars = str2.toCharArray();
        System.out.println(chars);//printStream.java
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        //String.getByte()字符串转为字节数组
        byte[] bt = str2.getBytes();
        System.out.println(Arrays.toString(bt));//[65, 66, 67, 68]
        System.out.println(Arrays.toString("你好".getBytes("UTF-8")));

        //****String.charAt(int index)根据索引找字符****
        for (int i = 0; i < str2.length(); i++) {
            System.out.println(str2.charAt(i));
        }

        //String.indexOf(int ch)根据字符找index
        //String.indexOf(int ch, int fromIndex)
        //String.lastIndexOf(int ch)
        String str3 = "asfsldfsdfewofn324大师是f发射点sdsfsd";
        int index = str3.indexOf('d');//char类型自动提升int
        System.out.println(index);//5
        System.out.println(str3.indexOf('d',index+1));//8
        System.out.println(str3.lastIndexOf('d'));//30

        //String.indexOf(String str) 查找子串index
        //String.indexOf(String str,int fromIndex)
        //String.lastIndexOf(String str)
        int index1 = str3.indexOf("sd");
        System.out.println(index1);//7
        System.out.println(str3.indexOf("sd",index1+"sd".length()));//25

        //截取 String.substring(int fromIndex,int endIndex)  [fromIndex,endIndex)
        String str4 = "d:\\doit\\zll\\str.DOC";
        String fileName = str4.substring(str4.lastIndexOf("\\")+1);
        System.out.println(fileName);

        //String replace(char oldValue,char newValue)
        System.out.println(str4.replace('\\','.'));
        String str5 = "  a    b              c  d     e ";
        //String.trim()去掉字符串两端的空格
        System.out.println(str5.trim().replaceAll(" +","-"));
        //tolowerCase()
        System.out.println(str4.toLowerCase().endsWith(".doc"));//true
        //判断username已存在
        String userName1 = "abc";
        String userName2= "abc  ".trim();
        System.out.println(userName1.equals(userName2));//true

        //split("\\.+") 返回字符串数组
        String s = "a...b..c.d.e...f..";
        String[] arrStr = s.split("\\.+");
        System.out.println(Arrays.toString(arrStr));
    }
}
