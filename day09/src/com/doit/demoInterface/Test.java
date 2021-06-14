package com.doit.demoInterface;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/14 10:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        //接口类多态
        Fly f = new Bird();
        f.fly();


    }


}
