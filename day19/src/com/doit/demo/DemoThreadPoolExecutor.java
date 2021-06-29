package com.doit.demo;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @ClassName: DemoThreadPoolExecutor
 * @Author: zll
 * @CreateTime: 2021/6/29 11:11
 * @Desc: java 程序
 * @Version: 1.0
 */
//经常用这个
public class DemoThreadPoolExecutor {
   public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if (s.equals("stop")){
                    flag = false;
                }
            }
        }.start();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                3,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            pool.submit(new RunTask(i));
        }

    }

     static class RunTask implements Runnable {
        private int num;

        public RunTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"...."+ num);
             while (flag){

             }
        }
    }
}

