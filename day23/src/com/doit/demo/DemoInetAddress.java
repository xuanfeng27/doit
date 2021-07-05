package com.doit.demo;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: demo
 * @Author: zll
 * @CreateTime: 2021/7/4 17:41
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
 网络编程，就是在一定的协议下，实现两台计算机的通信的程序
 C/S结构：全称为Client/Server结构，是指客户端和服务器结构。常见程序有ＱＱ、迅雷等软件。
 B/S结构 ：全称为Browser/Server结构，是指浏览器和服务器结构。常见浏览器有谷歌、火狐等

 dos命令：
 ipconfig
 ping localhost
 ping www.baidu.com

 InetAddress 类:
    static InetAddress getLocalHost();

 */
public class DemoInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //获取当前计算机IP对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        String hostAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();
        System.out.println(hostAddress);

        InetAddress byName1 = InetAddress.getByName(hostName);
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
    }
}
/*
     java.net.InetAddress
          静态方法创建对象
             static InetAddress getLocalHost()   获取本机IP对象

             static InetAddress getByName(String HostName) 根据主机名获取  但是主机名可能重复
                                                          这个方法可以直接传入IP 或者网址


          方法
            String getHostName() 获取主机名
            String getHostAddress() 获取IP地址
 */