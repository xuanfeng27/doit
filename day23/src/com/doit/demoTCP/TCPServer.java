package com.doit.demoTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: TCPServer
 * @Author: zll
 * @CreateTime: 2021/7/5 14:56
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
 java.io.ServerSocket 服务端
           构造方法
              public ServerSocket(int port)   创建服务器绑定端口
           方法
              Socket  accept()  获取正在连接的客户端对象

1.创建服务端对象，绑定端口号
2.调用accept方法，获取正在连接的客户端对象
3.通过当前客户端对象，获取字节输入流
4.接收客户端发送过来的数据  “你好”
5.通过当前客户端对象 获取字节输出流
6.向当前客户端返回数据  “不好”
7.关闭资源
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        InputStream in = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));
        System.out.println("-------------------------------------------------");
        OutputStream out = socket.getOutputStream();
        out.write("不好".getBytes());

        in.close();
        out.close();
        socket.close();
        ss.close();

    }
}
