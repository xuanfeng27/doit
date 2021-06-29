package com.doit.demoFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: DemoCreateFile
 * @Author: zll
 * @CreateTime: 2021/6/29 15:41
 * @Desc: java 程序
 * @Version: 1.0
 */
//File
// 创建文件  createNewFile()
// 创建文件夹 mkdirs()
public class DemoCreateFile {
    public static void main(String[] args) throws IOException {
        File file = new File("day19\\src\\com\\doit\\demoFile\\1.doc");
        boolean b = file.createNewFile();
        System.out.println(b);//不存在就创建返回true ,存在就不创建返回false
        boolean delete = file.delete();
        System.out.println(delete);//true 删除 不走回收站

        File file2 = new File("day19\\src\\com\\doit\\demoFile\\bbb");
        boolean b2 = file2.mkdirs();
        System.out.println(b2);
        boolean delete2 = file2.delete();
        System.out.println(delete2);
    }
}
