package com.doit.demoFile;

import java.io.File;

/**
 * @ClassName: DemoFileList
 * @Author: zll
 * @CreateTime: 2021/6/29 17:07
 * @Desc: java 程序
 * @Version: 1.0
 */

// 直接递归: 递归函数的函数体中存在显式的自我调用时，被称为直接递归
//尾递归(tail recursion):
//一个递归函数被称为尾递归函数，如果在递归调用的过程中不存在未决操作的话。
//尾递归函数通常被描述为：“返回上次递归调用得到的值作为函数的返回值。”尾递归具有很大的价值，
// 因为在(递归)计算过程中需要维护的信息量与递归调用次数是无关的。

public class DemoFileList {
    public static void main(String[] args) {
        File file = new File("D:\\zll\\doitedu\\基础讲义\\day02");

        methods(file);

    }

    public static void methods(File file) {
        File[] files = file.listFiles();
        for (File fi:files){
            if (fi.isFile()){
               if(fi.getName().toLowerCase().endsWith(".java"))
                   System.out.println(fi);
            }else {
                methods(fi);
            }
        }
    }

   /* public static int method(int n){
        if(n == 1){
            return 1;
        }
        return n*method(n-1);
    }*/

    public static int method(int n) {
        return method_recur(n,1);
    }
    public static int method_recur(int n, int result) {
        if(n == 1){
            return result;
        }
        return method_recur(n-1,n*result);
    }
}
