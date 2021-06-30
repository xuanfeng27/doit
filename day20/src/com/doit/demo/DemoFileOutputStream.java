package com.doit.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//true为续写,默认为false
/**
 * @ClassName: DemoFileOutputStream
 * @Author: zll
 * @CreateTime: 2021/6/30 11:34
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
     IO流
         输入输出流
         输入:从硬盘中的文件 到内存中的程序
         输出:从内存中的程序 到 硬盘上的文件

     IO流的分类
        按照操作的数据不同
             字节流
                 一次操作一个字节,由于计算机上一切数据都是由字节构成
                 所以字节流可以操作计算机上的一切数据 例如 .txt .avi .jpg .exe .mp3 等等
             字符流
                 一次操作一个字符,对于字符流来说只能操作文本文件
                 文本文件:用记事本 notepad+=打开 能看懂不乱码 就是文本文件
                         例如  .txt .java .html .css .js .xml等等
                 需要注意:word  excel  不是文本文件


       按照流向不同
          输入流
          输出流


      字节输入流
          InputStream
                 read 读字节
          FileInputStream
      字节输出流
          OutputStream
                 write 写字节
          FileOutputStream
      字符输入流
          Reader
                 read 读字符
          FileReader
      字符输入流
          Writer
                 wrtie 写字符
          FileWriter


      IO流的命名规则 :一般情况下 前面是这个流能干什么 后面是这个流的父类是谁

 */
public class DemoFileOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("d:\\zll\\apps\\fos.txt",true);
        fos.write("\r\n你好\r\n".getBytes());
        fos.write("我好\r\n".getBytes());
        fos.write("大家好\r\n".getBytes());
        fos.close();
    }
}
