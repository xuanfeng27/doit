package com.doit.demoFile;

import java.io.File;

/**
 * @ClassName: DemoFileConstructor
 * @Author: zll
 * @CreateTime: 2021/6/29 15:02
 * @Desc: java 程序
 * @Version: 1.0
 */

//File构造方法
// public File(String str) {}
// public File(String parent,String child){}
// public File(File parent,String child){}
//URI 统一资源标识符  包括URL mailTo ftp
// URL统一资源定位符
public class DemoFileConstructor {
    public static void main(String[] args) {
        File file = new File("D:\\zll\\apps\\1.txt");
        System.out.println(file);

        File file2 = new File("D:\\zll\\apps","2.txt");
        System.out.println(file2);

        File parent = new File("D:\\zll\\apps");
        File file3 = new File(parent,"3.txt");
        System.out.println(file3);


    }
}
