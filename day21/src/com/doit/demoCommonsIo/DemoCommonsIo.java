package com.doit.demoCommonsIo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @ClassName: DemoCommonsIo
 * @Author: zll
 * @CreateTime: 2021/7/2 19:25
 * @Desc: java 程序
 * @Version: 1.0
 */

public class DemoCommonsIo {
    public static void main(String[] args) throws IOException {
      ioUtils();
      fileUtils();
    }

    public static void ioUtils() throws IOException {
        // IOUtils 主要操作流对象
       /* byte[] bytes = new byte[1024];
        InputStream is = new FileInputStream(new File("d:\\zll\\apps\\1.txt"));
        int length = IOUtils.read(is, bytes);
        System.out.println(length);
        System.out.println(Arrays.toString(bytes));*/

        InputStream is = new FileInputStream(new File("d:\\zll\\apps\\1.txt"));
        OutputStream os = new FileOutputStream(new File("day21\\src\\com\\doit\\demoCommonsIo\\IO.txt")) ;
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(is);


    }

    /*
         FileUtils 主要操作File对象
              String readFileToString(File file) 将文件中的数据 读取为字符串
              writeStringToFile(File file,String data) 向文件中写字符串

              copyFile(File src ,File dest) 复制文件


            NIO
     */
    public static void fileUtils() throws IOException {
       /* File src = new File("d:\\zll\\apps\\test");
        File dest = new File("d:");
        FileUtils.copyDirectoryToDirectory(src,dest);*/
        String s = FileUtils.readFileToString(new File("d:\\zll\\apps\\test\\copy1\\test.java"));
        System.out.println(s);
    }


}
