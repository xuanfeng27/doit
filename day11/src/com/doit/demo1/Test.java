package com.doit.demo1;

import java.util.Scanner;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/17 19:37
 * @Desc: java 程序
 * @Version: 1.0
 */
//键盘录入一个字符串，使用程序实现在控制台遍历该字符串
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
       /* for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }*/

        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }
    }
}

//统计字符次数
//键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
class Test1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        int bigCount =0,smallCount=0,numCount=0;
        for (int i = 0; i < str.length(); i++) {
            char chs =  str.charAt(i);
            if (chs >= 'A' && chs <= 'Z') {
                bigCount++;
            }else if(chs >= 'a' && chs <= 'z'){
                smallCount++;
            }else if(chs >= '0' && chs <= '9'){
                numCount++;
            }
        }
        System.out.println(bigCount);
        System.out.println(smallCount);
        System.out.println(numCount);
    }
}

//字符串反转
//定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果
class Test2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        //System.out.println(reverseStr(str));
        System.out.println(reverseStr1(str));
    }

    //方法一
    public static String reverseStr(String str){
        StringBuilder sb = new StringBuilder();
       // return sb.append(str).reverse().toString();
        for (int i = str.length()-1; i >=0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //方法二
    public static String reverseStr1(String str){
        char[] chs = str.toCharArray();
        char ch = chs[0];
        for (int i = 0; i < chs.length / 2; i++) {
            ch = chs[i];
            chs[i] = chs[chs.length-1-i];
            chs[chs.length-1-i] = ch;
        }
        return new String(chs);
    }
}