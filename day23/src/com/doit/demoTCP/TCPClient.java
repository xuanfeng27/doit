package com.doit.demoTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: TCPClient
 * @Author: zll
 * @CreateTime: 2021/7/5 14:56
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
    TCP客户端
         java.net.Socket
               构造方法
                   public Socket(InetAddress ip,int port)
                   public Socket(String ip,int port)

               方法
                  InputStream getInputStream()
                  OutputStream getOutputStream()

1.创建客户端对象，绑定服务器IP和端口
2.获取字节输出流对象
3.向服务器写数据  “你好”
4.获取字节输入流对象
5.接收服务器返回的数据  “不好”
6.关闭资源
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",9999);
        OutputStream out = s.getOutputStream();
        out.write("你好".getBytes());

        System.out.println("--------------------------------------");
        InputStream in = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes, 0, len));

        out.close();
        in.close();
        s.close();
    }
}
