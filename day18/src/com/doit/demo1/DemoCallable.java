package com.doit.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: DemoCallable
 * @Author: zll
 * @CreateTime: 2021/6/27 17:24
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
与使用Runnable相比， Callable功能更强大些
 相比run()方法，可以有返回值
 方法可以抛出异常
 支持泛型的返回值
 需要借助FutureTask类，比如获取返回结果
 */
public class DemoCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Call call = new Call(100);
        FutureTask<Integer> ft = new FutureTask<>(call);
        new Thread(ft).start();
        Integer i1 = ft.get();
        System.out.println(i1);

        Call call2 = new Call(200);
        FutureTask<Integer> ft2 = new FutureTask<>(call2);
        new Thread(ft2).start();
        Integer i2 = ft2.get();
        System.out.println(i2);

    }
}

class Call implements Callable<Integer> {
    private int num;
    private int s;


    public Call(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= num; i++) {
            s += i;
        }
        return s;
    }
}