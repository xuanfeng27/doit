package com.doit.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: DemoCondition
 * @Author: zll
 * @CreateTime: 2021/6/26 20:38
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
public void await()	线程等待
public void signal()	唤醒一个等待的线程
public void singalAll()	唤醒所有等待的线程

Condition接口方法和Object类方法比较:
Condition可以和任意的Lock组合，也就是实现了线程的分组管理。
一个线程的案例中，可以使用多个Lock锁，每个Lock锁上可以结合Condition对象   synchronized同步中做不到线程分组管理
Object类wait()和notify()都要和操作系统交互，并通知CPU挂起线程，唤醒线程，效率低。
Condition接口方法await()不和操作系统交互，而是让线程释放锁，并存放到线程队列容器中，当被signal()唤醒后，从队列中出来，从新获取锁后在执行。
因此使用Lock和Condition的效率比Object要快很多。
 */
public class DemoCondition {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //面向接口编程 生产者消费者线程
        Lock lock = new ReentrantLock();
        Condition product = lock.newCondition();
        Condition consumer = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                        if (list.size() != 0){
                            try {
                                product.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.add("aaa");
                        System.out.println(list);
                        consumer.signal();
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                        if (list.size() == 0) {
                            try {
                                consumer.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.remove(0);
                        System.out.println(list);
                        product.signal();
                    lock.unlock();
                }
            }
        }).start();
    }
}
