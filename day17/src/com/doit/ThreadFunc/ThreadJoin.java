package com.doit.ThreadFunc;

/**
 * @ClassName: ThreadJoin
 * @Author: zll
 * @CreateTime: 2021/6/26 14:30
 * @Desc: java 程序
 * @Version: 1.0
 */
//三条线程同时开启，如何保证t1 t2 t3顺序执行?
//t1.join() t1插队，当前线程（Thread.currentThread()）等待
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("t1 ..."+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    t1.join();//t2等待t1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 50; i++) {
                    System.out.println("t2 ..."+i);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    t2.join();//t3等待t2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 50; i++) {
                    System.out.println("t3 ..."+i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
