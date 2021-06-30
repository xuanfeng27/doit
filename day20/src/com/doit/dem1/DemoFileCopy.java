package com.doit.dem1;

import java.io.*;

/**
 * @ClassName: DemoFileCopy
 * @Author: zll
 * @CreateTime: 2021/6/30 15:25
 * @Desc: java 程序
 * @Version: 1.0
 */
//复制文件
public class DemoFileCopy {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream("d:\\zll\\Pictures\\073ycDa.jpg");
            in = new FileInputStream("d:\\zll\\apps\\073ycDa.jpg");
            int data = -1;
            while ((data = in.read())!= -1){
                out.write(data);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
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

        long l = System.currentTimeMillis();
        copyFile();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    public static void copyFile() {
        InputStream in = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream("d:\\zll\\Pictures\\jdk-9_汉化版.CHM");
            in = new FileInputStream("d:\\zll\\apps\\jdk-9_汉化版.CHM");
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes))!= -1){
                out.write(bytes, 0, len);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
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

}
