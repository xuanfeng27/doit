package com.doit.ThreadFunc;

/**
 * @ClassName: ThreadFunc
 * @Author: zll
 * @CreateTime: 2021/6/26 11:18
 * @Desc: java 程序
 * @Version: 1.0
 */
//Thread 方法
// 静态方法 static void sleep(long time)
//设置优先级 setPriority(Thread.MAX_PRIORITY) 不保证准确，不常用
public class ThreadFunc {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(200);
            System.out.println(i);
        }


        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "..."+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "..."+i);
                }
            }
        });
        //设置优先级
        //t1.setPriority(Thread.MIN_PRIORITY);
       // t2.setPriority(Thread.MAX_PRIORITY);
        t2.setDaemon(true);//设置t2为守护线程，t1（用户线程）执行完后，t2还没执行完，就退出JVM虚拟机了
        t1.start();
        t2.start();
    }
}
