package com.doit.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: DemoOutPutStream
 * @Author: zll
 * @CreateTime: 2021/6/30 11:01
 * @Desc: java 程序
 * @Version: 1.0
 */
//读入内存，写入硬盘
/*
常用子类：Java.io.FileOutputStream
构造方法，绑定数据目的
public FileOutputStream(File file)
public FileOutputStream(String path)
方法：
write(int b)写入一个字节
write(byte[] bytes)写入字节数组
write(byte[] bytes,int start,int len)
 */
public class DemoOutputStream {
    public static void main(String[] args) throws IOException {
        //没有文件夹报错FileNotFoundException，没有文件创建文件，有文件创建文件覆盖
        OutputStream out = new FileOutputStream("d:\\zll\\apps\\fos.txt");
        /*
        0000 0000
        0000 0000
        0000 0000
        0000 1010
        只取低八位，高位舍弃
         */
        out.write(49);
        out.write(48);
        out.write("hello,java".getBytes());
        out.write("1234567".getBytes(),0,2);
        out.close();//IO流对象本身没有读写功能，需要调用操作系统的读写功能


    }
}

/*
     java.io.OutputStream  所有字节输出里的超类 抽象类
           方法
               write(int b ) 写一个字节
               write(byte[] bytes) 写一个字节数组
               write(byte[] bytes,int start ,int length) 写字节数组的一部分
               close() 关闭资源
                       IO流对象一般情况 本身都没有读写功能 需要调用操作系统的读写功能
                       就会和操作系统进行交互 进行读写之后 需要告知操作系统 读写完毕
                       这样操作系统就不会占用文件资源了


           常用子类
              java.io.FileOutputStream
                  构造方法 绑定数据目的
                      public FileOutputStream(File file)
                      public FileOutputStream(String path)


                  如果文件夹不存在 抛出 FileNotFoundException
                  如果文件不存在 自动创建一个文件
                  如果文件存在 创建一个空文件 覆盖原来的文件

 */