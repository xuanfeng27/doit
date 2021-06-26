package com.doit.ThreadSafe;

/**
 * @ClassName: ThreadWait
 * @Author: zll
 * @CreateTime: 2021/6/26 17:02
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
 Object类
         void wait()  让当前线程在对象监视器上等待  直到被唤醒
                      此方法必须由对象监视器调用 也就是说wait方法 必须在同步中使用

         void wait(long time)  在time时间内 如果有人唤醒就直接唤醒 如果在时间内没人唤醒 到时间了自己醒来

         void  notify()  唤醒在此对象监视器上等待的线程 其中一个  此方法必须由对象监视器调用

    wait和sleep的区别:

        wait是Object类的方法  必须由锁对象调用 必须在同步中使用 必须有人唤醒
        当线程遇到wait进行等待 此时 线程会释放掉锁

        sleep是Thread的静态方法  当前线程遇到sleep进入到睡眠状态 到时间后自动醒来 继续执行
        sleep可以在同步中使用 也可以在同步外使用  如果sleep在同步中使用 线程遇到sleep后进入到睡眠状态
        但是并不会释放锁
 */
public class ThreadWait {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (o){
                    try {
                        System.out.println("开始等待");
                        o.wait(100);
                        System.out.println("等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

        Thread.sleep(3000);

        synchronized (o) {
            o.notify();
            System.out.println("开始唤醒");
        }
    }
}
