package com.doit.demo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @ClassName: demoUDPsend
 * @Author: zll
 * @CreateTime: 2021/7/5 11:03
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
发送端
     java.net.DatagramSocket
          构造方法
               public DatagramSocket()   发送端对象
          方法
             void send(DatagramPacket p) 发送数据包

     java.net.DatagramPacket
          构造方法
              DatagramPacket(byte[] buf, int length, InetAddress address, int port)
                    用来将长度为 length 的包发送到指定主机上的指定端口号。

1.创建发送端对象
2.创建数据包对象，封装数据，指定接收端的端口和IP
3.调用发送端的send方法
4.关闭资源
 */
public class DemoUDPsend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,8888);
            ds.send(dp);
        }

        //ds.close();
    }
}
