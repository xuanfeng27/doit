package com.doit.demoSingle;

/**
 * @ClassName: Singleton1
 * @Author: zll
 * @CreateTime: 2021/6/27 16:53
 * @Desc: java 程序
 * @Version: 1.0
 */

//单例模式--饿汉式
//优点多线程安全，缺点类加载创建对象，占用内存空间
public class TestSingleton1 {
    public static void main(String[] args) {
       // Singleton s = Singleton.getInstance();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Singleton.getInstance());
                }
            }).start();
        }

    }
}



class Singleton {

    private static Singleton s = new Singleton();

    private Singleton() { }

    public static Singleton getInstance(){
        return s;
    }

}