package com.doit.demo;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName: DemoThreadPool
 * @Author: zll
 * @CreateTime: 2021/6/29 9:56
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoThreadPool {
    public static void main(String[] args) {
        //不常用，熟悉即可
        ExecutorService pool = Executors.newFixedThreadPool(2);
       // pool = Executors.newSingleThreadExecutor();
       // pool = Executors.newCachedThreadPool();
       // ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(2);
       // pool2.schedule(new Task(100),3,TimeUnit.SECONDS);

        pool.submit(new Task(100));
        pool.submit(new Task(200));
        pool.submit(new Task(300));
        pool.submit(new Task(400));

        pool.shutdown();

       // List<Runnable> r = pool.shutdownNow();
    }
}

class Task implements Runnable {
    private final int sum;

    public Task(int sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
         int rlt = 0;
        for (int i = 1; i <= sum; i++) {
            rlt+=i;
        }
        System.out.println(Thread.currentThread().getName()+ "..."+ rlt);
    }
}
