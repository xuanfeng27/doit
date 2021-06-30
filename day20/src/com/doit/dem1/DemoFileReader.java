package com.doit.dem1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName: DemoFileReader
 * @Author: zll
 * @CreateTime: 2021/6/30 16:36
 * @Desc: java 程序
 * @Version: 1.0
 */
//字符输入流
public class DemoFileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d:\\zll\\apps\\2.txt");
        int data = 0;
        while ( (data = fr.read())!= -1) {
            System.out.println((char) data);
        }
        fr.close();

        readFile();
    }

    public static void readFile() throws IOException {
        FileReader fr = new FileReader("d:\\zll\\apps\\2.txt");
        int len = 0;
        char[] chs = new char[1024];
        while ( (len = fr.read(chs))!= -1) {
            System.out.println(new String(chs, 0, len));
        }
        fr.close();
    }
}
/*
     java.io.Reader 所有字符输入流的超类 抽象类
          方法
              int read() 一次读一个字符  返回值就是读取到的内容
              int read(char[] chs) 一次读一个字符数组   返回值是读取的有效个数
              void close() 关闭资源

          常用实现类
              java.io.FileReader
                   构造方法 绑定数据源
                        public FileReader(String path)
                        public FileReader(File file)

 */