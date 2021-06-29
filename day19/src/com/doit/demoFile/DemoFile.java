package com.doit.demoFile;

import java.io.File;

/**
 * @ClassName: DemoFile
 * @Author: zll
 * @CreateTime: 2021/6/29 14:56
 * @Desc: java 程序
 * @Version: 1.0
 */
//File 静态常量
// static final String pathSeparator
//static final String separator
public class DemoFile {
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        String separator = File.separator;
        System.out.println(pathSeparator);// windows ;  linux :
        System.out.println(separator);//windows \  linux /


        String path = "work"+File.separator+"1.txt";// "work\\1.txt"
        System.out.println(path);

    }
}
