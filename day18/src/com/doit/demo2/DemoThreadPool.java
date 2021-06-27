package com.doit.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: DemoPool
 * @Author: zll
 * @CreateTime: 2021/6/27 20:31
 * @Desc: java 程序
 * @Version: 1.0
 */

//java.util.concurrent  JUC并发编程

//JDK 5.0起提供了线程池相关API：接口 ExecutorService 和 java.util.concurrent 类 Executors

public class DemoThreadPool {
    public static void main(String[] args) {

        RunTask task = new RunTask();
        // 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);

        threadPool.shutdown();
    }
}

class RunTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}