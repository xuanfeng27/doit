package com.doit.demo;

/**
 * @ClassName: DeadLock
 * @Author: zll
 * @CreateTime: 2021/6/27 19:57
 * @Desc: java 程序
 * @Version: 1.0
 */

//1---IN1 和 2---IN2 组合就会发生死锁
public class DeadLock {
    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (MyLock.IN1){
                        System.out.println("1---IN1");
                        synchronized (MyLock.IN2){
                            System.out.println("1---IN2");
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (MyLock.IN2){
                        System.out.println("2---IN2");
                        synchronized (MyLock.IN1){
                            System.out.println("2---IN1");
                        }
                    }
                }
            }
        }).start();

    }
}

class MyLock {
    public static final MyLock IN1 = new MyLock();
    public static final MyLock IN2 = new MyLock();

}