package com.doit.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: DemoInputStream
 * @Author: zll
 * @CreateTime: 2021/6/30 11:58
 * @Desc: java 程序
 * @Version: 1.0
 */
//read()
public class DemoInputStream {
    public static void main(String[] args)  {
        InputStream in = null;
        try {
            in = new FileInputStream("d:\\zll\\apps\\1.txt");
            int data = 0;
            while ((data = in.read()) != -1) {
                System.out.println(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
/*

    InputStream类
      int read(byte[] bytes)

      byte[] bytes: 缓冲的作用 每次调用操作系统 读取到的数据 先放入到byte数组中
      int: 返回的是每次读取的个数
 */