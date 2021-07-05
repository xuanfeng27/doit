package com.doit.demoTCP;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName: UploadClient
 * @Author: zll
 * @CreateTime: 2021/7/5 16:01
 * @Desc: java 程序
 * @Version: 1.0
 */
//文件上传客户端

    /*
    文件上传客户端


      数据源:d:\zll\apps\073ycDa.jpg
      数据目的:服务器

      1.创建客户端对象 绑定服务端IP和端口
      2.创建FileInputStream对象 绑定数据源
      3.获取字节输出流对象
      4.循环读写
      5.获取字节输入流对象
      6.接收服务器返回的数据  上传成功
      7.关闭资源


 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",5555);
        FileInputStream fis = new FileInputStream("d:\\zll\\apps\\073ycDa.jpg");
        OutputStream out = s.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes))!=-1) {
            out.write(bytes, 0, len);
        }
        s.shutdownOutput();

        System.out.println("-------------客户端上传完成---------------");
        InputStream in = s.getInputStream();
        int length = in.read(bytes);
        System.out.println(new String(bytes, 0, length));

        fis.close();
        out.close();
        in.close();
        s.close();
    }
}
