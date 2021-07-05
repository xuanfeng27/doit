package com.doit.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @ClassName: DemoUDPreceive
 * @Author: zll
 * @CreateTime: 2021/7/5 11:04
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
  UDP接收端
         java.net.DatagramSocket
               构造方法
                   public DatagramSocket(int port)  接收端对象
               方法
                   void receive(DatagramPacket p)  接收数据包

         java.net.DatagramPacket
                构造方法
                      public  DatagramPacket(byte[] buf, int length)
                                    用来接收长度为 length 的数据包。

1.创建接收端对象 填写端口号
2.创建接收端数据包对象
3.调用receive()方法接收数据包
4.拆包
5.关闭资源
 */

public class DemoUDPreceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);
        while (true) {
            byte[] bytes = new byte[1024*64];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            int length = dp.getLength();
            InetAddress address = dp.getAddress();
            int port = dp.getPort();
            System.out.println(address +":" +port + "   "+ new String(bytes, 0, length));
        }

        //ds.close();
    }
}
