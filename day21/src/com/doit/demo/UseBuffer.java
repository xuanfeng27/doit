package com.doit.demo;

import java.io.*;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @ClassName: UseBuffer
 * @Author: zll
 * @CreateTime: 2021/7/2 9:22
 * @Desc: java 程序
 * @Version: 1.0
 */
public class UseBuffer {
    public static void main(String[] args) throws IOException {
        //bufferStream();

        /*long l = System.currentTimeMillis();
        bufferCopyFile();
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);*/

       // bufferReadWrite();

        bufferSortFile();
    }

    public static void bufferStream() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demo\\buffer.txt");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file,true));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(len);
            bos.write(bytes,0,len);
        }
        bos.write("hello".getBytes());
        bos.close();
        bis.close();
    }

    public static void bufferCopyFile() throws IOException {
        File file = new File("D:\\zll\\apps\\jdk-9_汉化版.CHM");
        File fileOut = new File("D:\\zll\\jdk-9_汉化版.CHM");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOut));
        int len = 0;
        byte[] bytes = new byte[1024*8];
        while ((len = bis.read(bytes)) != -1) {
           // System.out.println(len);
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }

    public static void bufferReadWrite() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demo\\buffer.txt");
        File fileOut = new File("day21\\src\\com\\doit\\demo\\bufferOut.txt");
        BufferedReader bis = new BufferedReader(new FileReader(file));
        BufferedWriter bos = new BufferedWriter(new FileWriter(fileOut));
        String line = null;
        while ((line = bis.readLine()) != null) {
             System.out.println(line);
             bos.write(line);
             bos.flush();//刷新
             bos.newLine();//换行，特有方法
        }
        bos.close();
        bis.close();
    }

    public static void bufferSortFile() throws IOException {
        File file = new File("day21\\src\\com\\doit\\demo\\sortTxt.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        String str = null;
        while ((str = br.readLine())!=null){
           // System.out.println(str);
            treeMap.put(str.substring(0,str.indexOf(".")),str.substring(str.indexOf(".")+1));
        }
        System.out.println(treeMap);
        Iterator<String> iterator = treeMap.keySet().iterator();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        while (iterator.hasNext()){
            String next = iterator.next();
            bw.write(next+"."+treeMap.get(next));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
/*
      java.io.BufferedInputStream  字节输入缓冲流
      继承自InpuStream
            方法
             int read() 读一个字节
             int read(byte[] bytes) 读一个字节数组
             void close() 关闭资源
           构造方法
             public BufferedInputStream(InputStream in)
                    方法的参数是InputStream in 所有字节输入流的超类  抽象类
                             但是可以传入其任意子类对象 FileInputStream

     java.io.BufferedOutputStream  字节输出缓冲流
     继承自OutputStream
           方法
             write(int b) 写一个字节
             write(byte[] bytes) 写一个字节数组
             write(byte[] bytes,int start ,int length) 写字节数组的一部分
             void clode() 关闭资源
           构造方法
              public BufferedOutputStream(OutputStream out)
                   方法的参数是OutputStream out 所有字节输出流的超类 抽象类
                           可以传入其任意子类对象  FileOutputStream

 */
/*
     java.io.BufferedReader  字符输入缓冲流
     继承自Reader
             int read() 读一个字符
             int read(char[] chs) 读一个字符数组
             void close() 关闭资源
      特有方法
             String readLine() 读取一行数据 读取\r\n之前的数据 返回值为读取的数据

            构造方法
                 public BufferedReader(Reader r )
                        参数为Reader r 所有字符输入流的超类  抽象类
                               可以传入其任意子类对象  FileReader


                               String s = "null";
                               String s = null;

 */

/*
     java.io.BufferedWriter  字符输出缓冲流
     继承自Writer
              方法
                 write(int c) 写一个字符
                 write(char[] chs) 写字符数组
                 write(char[] chs,int start,int length) 写字符数组的一部分
                 write(String str) 写字符串
                 close() 关闭资源
                 flush() 刷新缓冲区
              特有方法
                  void newLine() 写换行

              构造方法
                  public BuferedWriter(Writer w)
                          Writer w : 所有字符输出流的超类 抽象类
                                     可以传入其任意子类对象 FileWiter
 */