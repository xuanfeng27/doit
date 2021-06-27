package com.doit.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AtomicDemo
 * @Author: zll
 * @CreateTime: 2021/6/27 11:36
 * @Desc: java 程序
 * @Version: 1.0
 */
//并发三大特性之一：原子性
//原子类（CAS无锁机制）compare and swap
public class AtomicDemo {
    static volatile int a = 0;//volatile无法保证原子性，可以保证可见性
    static AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ai = new AtomicInteger();//0
        ai.incrementAndGet();//++i   相当于 addAndGet(1)
        ai.getAndIncrement();//i++   相当于 getAndAdd(1)
        System.out.println(ai.get());//2
        ai.addAndGet(2);
        System.out.println(ai.get());//4
        ai.getAndAdd(2);
        System.out.println(ai.get());//6

        method();
    }

    public static void method() throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    a++;
                    b.getAndIncrement();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    a++;
                    b.getAndIncrement();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(a);// <20000
        System.out.println(b);//20000保证原子性 CAS乐观锁
    }
}

/*
volatile关键字有两个作用
1.保证可见性
2.禁止重排序
注意:锁也可以保证有序性,因为在代码块中,一次只有一个线程执行,cpu系统重排对单线程执行是没有任何影响的.
 */