package com.doit.demo1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName: DemoTimer
 * @Author: zll
 * @CreateTime: 2021/6/27 17:50
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoTimer {
    public static void main(String[] args) {

        Timer t = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("time task 2秒/次");
            }
        };
        t.schedule(task,new Date(),2000);
    }
}
