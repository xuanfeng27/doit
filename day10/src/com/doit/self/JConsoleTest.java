package com.doit.self;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Jconsole
 * @Author: zll
 * @CreateTime: 2021/6/15 19:19
 * @Desc: java 程序
 * @Version: 1.0
 */

public class JConsoleTest {
    public byte[] b1 = new byte[128 * 1024];
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("start...");
        fill(1000);
    }

    private static void fill(int n) {
        List<JConsoleTest> jlist = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jlist.add(new JConsoleTest());
        }
    }
}
