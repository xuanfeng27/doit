package com.doit.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: DemoInputException
 * @Author: zll
 * @CreateTime: 2021/6/30 15:11
 * @Desc: java 程序
 * @Version: 1.0
 */
// int read(byte[] bytes)
public class DemoInputException {
    public static void main(String[] args) {

        InputStream in = null;
        try {
            in = new FileInputStream("d:\\zll\\apps\\1.txt");
            byte[] bytes = new byte[2];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                System.out.println(len+".....");
                System.out.println(new String(bytes, 0, len));
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
