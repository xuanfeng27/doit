package com.doit.demo;

//day19 阻塞队列、线程池、File类、递归

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/28 15:03
 * @Desc: java 程序
 * @Version: 1.0
 */

class DemoBlockQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> b = new ArrayBlockingQueue<>(5);
       /* b.put("aaa");
        b.put("bbb");
        b.put("ccc");
        b.put("ddd");
        b.put("eee");*/
       // System.out.println(b);
       // b.put("6");//阻塞了

        BlockingQueue<String> b2 = new LinkedBlockingQueue<>();

        BlockingQueue<String> b3 = new SynchronousQueue<>();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        b3.put(""+i);
                        System.out.println("添加"+i);
                    }
                }catch (Exception e) {

                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        b3.take();
                        System.out.println("取出"+i);
                    }
                }catch (Exception e) {

                }
            }
        }).start();
    }
}


