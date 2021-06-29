package com.doit.demo;

import java.util.concurrent.*;

/**
 * @ClassName: TestQueue
 * @Author: zll
 * @CreateTime: 2021/6/29 20:47
 * @Desc: java 程序
 * @Version: 1.0
 */

public class TestQueue {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallTask task = new CallTask(100);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                3,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<Integer> submit = pool.submit(task);
        Integer i = submit.get();
        System.out.println(i);
        pool.submit(new CallTask(200));
        pool.shutdown();

    }
}

class CallTask implements Callable<Integer> {
    private int num;

    public CallTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName());
        return sum;
    }
}