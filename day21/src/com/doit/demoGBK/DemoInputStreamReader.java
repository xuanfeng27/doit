package com.doit.demoGBK;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: DemoInputStreamReader
 * @Author: zll
 * @CreateTime: 2021/7/2 11:48
 * @Desc: java 程序
 * @Version: 1.0
 */
//转换流
public class DemoInputStreamReader {
    public static void main(String[] args) throws IOException {
       // gbkFile();

       // gbkToUtf8();

        inputToBuffer();
    }

    /*
         java.io.InputStreamReader
          继承自Reader  可以使用Reader的read方法

          构造方法
              public InputStreamReader(InputStream in)  idea默认编码
              public InputStreamReader(InputStream in,String charsetName) 指定编码
                        String charsetName:指定编码表 编码表不能乱写会抛异常 gbk utf-8 不区分大小写

     */
    /*
      java.io.OutputStreamWriter
         继承自 Writer 可以使用write方法

         构造方法
              public OutputStreamWriter(OutputStream out)  idea默认编码
              public OutputStreamWriter(OutputStream out,String charsetName) 指定编码
 */
    public static void  gbkFile() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demoGBK\\gbkTest.txt");
        Reader in = new InputStreamReader(new FileInputStream(file),"gbk");
        char[] cbuf = new char[1024];
        int len = in.read(cbuf);
        in.close();
        Writer out = new OutputStreamWriter(new FileOutputStream(file,true), "gbk");
        out.write(cbuf, 0, len);
        out.close();
    }

    /*
          将一个GBK文件转换为 UTF-8文件

          读取文件时 使用GBk编码来读取 保证读取到的数据不乱码
          向一个文件中写数据时 使用utf-8去写 保证写出的数据不乱码

     */
    public static void gbkToUtf8() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demoGBK\\gbkTest.txt");
        File fileOut = new File("day21\\src\\com\\doit\\demoGBK\\gbkToUtf8.txt");
        Reader in = new InputStreamReader(new FileInputStream(file), "gbk");
        Writer out = new OutputStreamWriter(new FileOutputStream(fileOut), StandardCharsets.UTF_8);
        int len = 0;
        char[] cbuf = new char[1024];
        while ((len = in.read(cbuf)) != -1) {
            out.write(cbuf, 0, len);
            out.flush();
        }
        out.close();
        in.close();
    }

    public static void inputToBuffer() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demoGBK\\gbkTest.txt");
        InputStream in = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();//读取第一行
        String s1 = s.split(" +")[1].substring(1);
        System.out.println(s1);
    }
}
