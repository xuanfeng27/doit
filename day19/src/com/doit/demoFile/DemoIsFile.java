package com.doit.demoFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: DemoIsFile
 * @Author: zll
 * @CreateTime: 2021/6/29 16:28
 * @Desc: java 程序
 * @Version: 1.0
 */
//isFile()  isDirectory()  exists()
public class DemoIsFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\zll\\apps\\1.txt");
        if(file.exists()){
            if (file.isFile()){//路径不存在也是false
                System.out.println("是文件");
            }else if (file.isDirectory()) {
                System.out.println("是文件夹");
            }
        }else {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        }
    }
}
