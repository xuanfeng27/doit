package com.doit.dem1;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName: DemoFileWrite
 * @Author: zll
 * @CreateTime: 2021/6/30 17:10
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoFileWrite {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:\\zll\\apps\\2.txt",true);
        fw.write("abcd");
        fw.flush();
        fw.write(97);
        fw.flush();
        char[] chs = new char[]{'1','2','p'};
        fw.write(chs);
        fw.flush();//字符流缓冲区，刷新一次才能写入数据目的

        fw.close();//关闭之前会进行一次刷新操作
    }
}
/*
     java.io.Writer 所有字符输出流的超类 抽象类
          方法
              write(int c) 写一个字符
              write(char[] chs) 写一个字符数组
              write(chra[] chs,int start,int length) 写字符数组的一部分
              write(String str) 写字符串

          常用实现类
               java.io.FileWriter
                   构造方法绑定 数据目的
                       public FileWriter(String path)
                       public FileWriter(File file)
                       public FileWriter(String path,boolean append)
                       public FileWriter(File file,boolean append)


       字符流有一个缓冲区 如果不刷新缓冲区 数据就不进入到数据目的
       所以 字符流每次写完数据 要进行一次刷新
       void flush()

       close是关闭资源的方法,在关闭之前会进行一次刷新操作
 */