package com.doit.demo;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @ClassName: DemoClassLoader
 * @Author: zll
 * @CreateTime: 2021/7/6 9:59
 * @Desc: java 程序
 * @Version: 1.0
 */
//双亲委托机制
public class DemoClassLoader {
    public static void main(String[] args) {
        app();
    }

    public static void boot(){
        ClassLoader c = String.class.getClassLoader();
        System.out.println(c);//null
    }

    public static void ext(){
        ClassLoader c = DNSNameService.class.getClassLoader();
        System.out.println(c);//sun.misc.Launcher$ExtClassLoader@74a14482
    }

    public static void app(){
        ClassLoader c = DemoClassLoader.class.getClassLoader();
        System.out.println(c);//sun.misc.Launcher$AppClassLoader@18b4aac2  （$代表 内部类）
        System.out.println(c.getParent());//
        System.out.println(c.getParent().getParent());
    }
}
