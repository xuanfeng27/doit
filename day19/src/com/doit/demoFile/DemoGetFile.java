package com.doit.demoFile;

import java.io.File;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: DemoGetFile
 * @Author: zll
 * @CreateTime: 2021/6/29 16:38
 * @Desc: java 程序
 * @Version: 1.0
 */
//getName()  getAbsolutePath();
public class DemoGetFile {
    public static void main(String[] args) {
        File file = new File("D:\\zll\\apps\\1.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(file.getPath());
        //获取文件名
        String name = file.getName();
        System.out.println(name);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        //获取文件字节数
        long length = file.length();
        System.out.println(length);
        URI uri = file.toURI();
        System.out.println(uri);
        //获取文件最后修改时间
        long l = file.lastModified();
        System.out.println(l);//毫秒
        Date date = new Date(l);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(date);
        System.out.println(format);

        //获取单极目录文件夹下所有
        File file2 = new File("D:\\zll\\apps");//必须是文件夹 否则返回null
        String[] list = file2.list();
        System.out.println(Arrays.toString(list));
        File[] files = file2.listFiles();
        for (File fi : files) {
            System.out.println(fi.getName());
        }
    }
}
