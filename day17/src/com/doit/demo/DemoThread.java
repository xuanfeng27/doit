package com.doit.demo;

/**
 * @ClassName: DemoThread
 * @Author: zll
 * @CreateTime: 2021/6/26 9:30
 * @Desc: java 程序
 * @Version: 1.0
 */

//创建线程方法一: 继承Thread类，重写run方法，开启线程任务start（）
//调用start和调用run方法的区别：run方法是单线程；
//为什么不直接创建Thread类对象？
// Thread d = new Thread();这样虽然开启了线程，但是执行的是他的run方法，不是我们想要的结果

public class DemoThread extends Thread {

    @Override
    public void run() {
        //int a = 3/0;互不影响
        //setName("aaa");//不推荐，这样两个线程同名了
        for (int i = 0; i < 100;i++){
            System.out.println(getName()+i);
        }
    }

    public DemoThread() {
    }

    public DemoThread(String name) {
        super(name);
    }
}

class TestThread{
    public static void main(String[] args) {
        DemoThread MyThread = new DemoThread("小白");
        MyThread.start();


        DemoThread myThread2 = new DemoThread();
        myThread2.setName("大白");
        myThread2.start();

        Thread t = Thread.currentThread();//获取当前主线线程，Thread类 静态方法

        for (int i = 0; i < 100; i++) {
            System.out.println(t.getName()+i);
        }
    }
}
