package com.doit.demo03;

import java.util.ArrayList;
import java.util.List;

/*
     ThreadLocal
        特点
             当前线程存储的数据 只能当前线程获取 其他线程获取不到

              void set(T value) 将此线程局部变量的当前线程副本中的值设置为指定值。
               T get() 返回此线程局部变量的当前线程副本中的值。
              void remove() 移除此线程局部变量当前线程的值。

 */
public class Demo01_ThreadLocal {
    public static void main(String[] args) throws InterruptedException {

        ThreadLocal<String> t = new ThreadLocal<>();

        t.set("abc");


        Thread.sleep(1000);

        System.out.println(t.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(t.get());
            }
        }).start();
    }
}
