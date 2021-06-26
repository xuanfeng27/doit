package com.doit.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ThreadSafe
 * @Author: zll
 * @CreateTime: 2021/6/26 14:52
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
线程安全问题都是由全局变量及静态变量引起的。若每个线程中对全局变量、静态变量只有读操作，而无写操作，一般来说，这个全局变量
是线程安全的；若有多个线程同时执行写操作，一般都需要考虑线程同步，否则的话就可能影响线程安全。
1.线程同步：都有锁，有锁的线程执行，没锁的线程等待
    ①.同步代码块
    synchronized(同步锁){
         需要同步操作的代码
    }
    ②.同步方法
    锁是 this
    public synchronized void method(){
        可能会产生线程安全问题的代码
    }
    静态方法 锁是 类名.class
    public static synchronized void method(){
        可能会产生线程安全问题的代码
    }
2.lock锁 JDK1.5出现
java.util.concurrent.locks.Lock接口机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。
public void lock():加锁。
public void unlock():释放锁。
 */
public class ThreadSafe {
    public static void main(String[] args) {
        SellTicket task = new SellTicket();

        Thread t1 = new Thread(task,"t1");
        Thread t2 = new Thread(task,"t2");
        Thread t3 = new Thread(task,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTicket implements Runnable{

    int number = 100;
    Object lock = new Object();
    Lock l = new ReentrantLock();//Lock接口实现类对象

    @Override
    public void run() {
        l.lock();
        while ( number >0) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"卖票了"+number);
                number--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        l.unlock();
       // sell();
      /*  synchronized (this){
            while ( number >0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖票了"+number);
                number--;
            }
        }*/
    }

    //同步方法
 /*   public synchronized void sell(){
        while ( number >0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖票了"+number);
            number--;
        }
    }*/

}

