package com.doit.demo;

/**
 * @ClassName: NiMingThread3
 * @Author: zll
 * @CreateTime: 2021/6/26 11:02
 * @Desc: java 程序
 * @Version: 1.0
 */
//匿名内部类创建线程

public class NiMingThread3 {
    public static void main(String[] args) {
        //第一种方式 创建Thread线程类子类对象开启线程
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName()+"..."+i);
                }
            }
        }.start();

        //第二种方式，创建线程任务对象，创建Thread类对象，开启

        new Thread( new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "..."+i);
                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "..."+i);
        }

    }
}
