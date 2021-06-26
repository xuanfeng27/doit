package com.doit.ThreadSafe;

import java.util.ArrayList;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/26 19:19
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
   当多条线程操作同一个资源 而操作的动作不同  此时 线程通信
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Object obj = new Object();
        //生产者
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (obj){
                    for (int i = 0; i < 5; i++) {
                        if(list.size() != 0){
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.add("aaa");
                        System.out.println(list);
                        obj.notify();
                    }
                }
            }
        }) ;

        //消费者
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (obj){
                    for (int i = 0; i < 5; i++) {
                        if (list.size() == 0) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.remove(0);
                        System.out.println(list);
                        obj.notify();
                    }
                }
            }
        }) ;

        t1.start();
        t2.start();

    }
}
