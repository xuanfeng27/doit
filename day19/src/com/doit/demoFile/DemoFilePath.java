package com.doit.demoFile;

import java.io.File;

/**
 * @ClassName: DemoFilePath
 * @Author: zll
 * @CreateTime: 2021/6/29 15:10
 * @Desc: java 程序
 * @Version: 1.0
 */
//绝对路径是唯一的，带盘符
// 相对路径可以有无数个 无盘符
public class DemoFilePath {
    public static void main(String[] args) {
        File file = new File("a.txt");//当前project路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        File file2 = new File("day19\\src\\com\\doit\\demoFile\\a.txt");
        File absoluteFile = file2.getAbsoluteFile();
        System.out.println(absoluteFile);


    }
}
