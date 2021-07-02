package com.doit.demoPrintStream;

import java.io.*;

/**
 * @ClassName: DemoPrint
 * @Author: zll
 * @CreateTime: 2021/7/2 17:00
 * @Desc: java 程序
 * @Version: 1.0
 */

    /*
     PrintStream  字节打印流
     PrintWriter  字符打印流

          字符打印流特点
                打印流只负责数据目的
                一般方法不抛出IO异常
                字符打印流可以开启自动刷新

     构造方法
         public printWriter(String path)
         public printWriter(File file)
         public printWriter(OutputStream out)
         public printWriter(OutputStream out,boolean autoFlush)
         public printWriter(Writer W)
         public printWriter(Writer w ,boolean autoFlush)

         boolean autoFlush:如果值为true 可以开启自动刷新 但是只针对3个方法开启自动刷新 println printf  format
 */
public class DemoPrint {
    public static void main(String[] args) throws FileNotFoundException {
       /* PrintStream out = System.out;
        out.println();*/
       printFile();
    }

    public static void printFile() throws FileNotFoundException {
        File file = new File("day21\\src\\com\\doit\\demoPrintStream\\print.txt");
      /*  PrintStream ps = new PrintStream(new FileOutputStream(file),true);
        ps.println(100);
        ps.print(true);
        ps.close();*/

        PrintWriter pw = new PrintWriter(new FileOutputStream(file), true);
        //自动刷新只对println,printf,format生效
        pw.println("aaa");
        pw.print(false);
        pw.write(99);
       // pw.close();

    }
}
