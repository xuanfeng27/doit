package com.doit.ThreadFunc;

/**
 * @ClassName: ThreadInterrupt
 * @Author: zll
 * @CreateTime: 2021/6/26 12:02
 * @Desc: java 程序
 * @Version: 1.0
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    boolean b = Thread.currentThread().isInterrupted();
                    System.out.println(b);
                    if (b) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"..."+i);
                }
            }
        });

        t1.start();

        try {
            Thread.sleep(5);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
