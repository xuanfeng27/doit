package com.doit.DemoThread;

/**
 * @ClassName: ThreadDemo
 * @Author: zll
 * @CreateTime: 2021/6/24 19:47
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
1. 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务,因此把run()方法称为线程执行体。
2. 创建Thread子类的实例，即创建了线程对象
3. 调用线程对象的start()方法来启动该线程
 */

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myTh = new MyThread("new thread");
        myTh.start();

        for (int i = 0; i < 100;i++){
            System.out.println("i am main"+i);
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100;i++){
            System.out.println("this is mythread"+i);
        }
    }
}
