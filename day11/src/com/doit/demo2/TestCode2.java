package com.doit.demo2;

import java.util.Scanner;

/**
 * @ClassName: TestCode2
 * @Author: zll
 * @CreateTime: 2021/6/17 20:34
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
    判断一个键盘录入的字符串是否是一个QQ号
          QQ号的规则
              1.长度 5-11
              2.0不能开头
              3.纯数字
 */
public class TestCode2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String str = sc.nextLine();
        System.out.println(checkQ(str));
    }

    public static boolean checkQ(String str){
        if(str.length()>11||str.length()<5){
            return false;
        }
        if(str.charAt(0)=='0'){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i)>='0'&& str.charAt(i)<='9')){
                return false;
            }
        }

        return true;
    }
}
