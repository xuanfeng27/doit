package com.doit.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: DemoIObuffer
 * @Author: zll
 * @CreateTime: 2021/6/30 20:03
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
InputStream
 int read()
从输入流中读取数据的下一个字节。返回 0 到 255 范围内的 int 字节值。如果因
为已经到达流末尾而没有可用的字节，则返回值 -1。
 void write(int b)
将指定的字节写入此输出流。write 的常规协定是：向输出流写入一个字节。要写
入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。 即写入0~255范围的。
FileOutputStream fos = new FileOutputStream(file,true);//在文件内容末尾追加内容，不覆盖。
FileInputStream fis = new FileInputStream(file);读取文件时，必须保证该文件已存在，否则报异常。
 字节流操作字节，比如：.mp3，.avi，.rmvb，mp4，.jpg，.doc，.ppt

Reader
int read()
读取单个字符。作为整数读取的字符，范围在 0 到 65535 之间 (0x00-0xffff)（2个
字节的Unicode码），如果已到达流的末尾，则返回 -1
 void write(int c)   void write(String str);
写入单个字符。要写入的字符包含在给定整数值的 16 个低位中，16 高位被忽略。 即
写入0 到 65535 之间的Unicode码。
void flush()
刷新该流的缓冲，则立即将它们写入预期目标。

 字符流操作字符，只能操作普通文本文件。最常见的文本文
件：.txt，.java，.c，.cpp 等语言的源代码。尤其注意.doc,excel,ppt这些不是文
本文件。
 */

/*
缓冲流：
 为了提高数据读写的速度，Java API提供了带缓冲功能的流类，在使用缓冲流时，会创建一个内部缓冲区数组，
 缺省使用8192个字节(8Kb)的缓冲区。
private static int DEFAULT_BUFFER_SIZE = 8192;
public BufferedInputStream(InputStream in) {
       this(in, DEFAULT_BUFFER_SIZE);
  }
  当使用BufferedInputStream读取字节文件时，BufferedInputStream会一次性从文件中读取8192个(8Kb)，存在缓冲区中，
  直到缓冲区装满了，才重新从文件中读取下一个8192个字节数组。
 */


public class DemoIObuffer {
    public static void main(String[] args)  {
        //File.separator路径分隔符
        File file = new File("d:\\zll\\apps\\1.txt");
        File fileOut = new File("d:\\1.txt");
      /*  boolean b = file.renameTo(fileOut);//剪切到D盘
        System.out.println(b);*/

        FutureTask<Object> task = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("call"+Thread.currentThread().getName());
                return 10;
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }


        //  getCharFrequency();

    }

/*
    获取文本上每个字符出现的次数
    提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
*/
    public static void getCharFrequency()  {
        File file = new File("d:\\zll\\apps\\1.txt");
        File fileOut = new File("d:\\1.txt");
        Map<Integer, Integer> map = new HashMap<>();
        int data = 0;
        BufferedReader bis =null;
        BufferedWriter bos =null;
        try {
            bis = new BufferedReader(new FileReader(file));
            bos = new BufferedWriter(new FileWriter(fileOut));
            while ((data = bis.read()) != -1) {
                if (!map.containsKey(data)) {
                    map.put(data, 1);
                }else {
                    map.put(data, map.get(data)+1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer key = next.getKey();
                Integer value = next.getValue();
                char i = (char) key.intValue();
                bos.write(i +"="+ value+"\r\n");
                bos.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
