package com.doit.demo2;

import java.util.Scanner;

/**
 * @ClassName: TestCode1
 * @Author: zll
 * @CreateTime: 2021/6/17 20:22
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
    说明：在网络程序中，如聊天室、聊天软件等，经常需要对一些用户所提交的聊天内容中的敏感性词语进行过滤。
    如""性"、""色情"、""爆炸"、""恐怖"、""枪"、""军火"等，
    这些都不可以在网上进行传播，需要过滤掉或者用其他词语替换掉
 */
public class TestCode1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String str = sc.nextLine();
        System.out.println(filter(str));
    }

    public static String filter(String str){
        String[] arr = {"性","色情","爆炸","恐怖","枪","军火"};
        for (int i = 0; i < arr.length; i++) {
            if(str.contains(arr[i])){
               str =  str.replace(arr[i],"***");
            }
        }
        return str;
    }
}
