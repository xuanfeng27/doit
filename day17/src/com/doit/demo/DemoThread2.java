package com.doit.demo;

/**
 * @ClassName: DemoThread2
 * @Author: zll
 * @CreateTime: 2021/6/26 9:59
 * @Desc: java 程序
 * @Version: 1.0
 */
//创建线程方法二：实现接口Runnable 重写run方法 ，创建实现类对象，创建Thread对象，构造方法传入线程任务对象，开启线程
//为啥有了第一种继承Thread方式，还有第二种实现接口方式？
// 1.避免Java单继承的局限性
// 2.将线程任务对象和线程对象分离，实现了解耦
// 3.第二种方式更适合多个线程，共享一个任务
public class DemoThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"..."+i);
        }
    }
}

class TestThread2{
    public static void main(String[] args) {

        DemoThread2 thread2 = new DemoThread2();//线程任务类对象

        Thread t = new Thread(thread2);//线程对象
        t.start();

        Thread t2 = new Thread(thread2);
        t2.start();//共享任务

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "..."+i);
        }
    }
}