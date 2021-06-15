package com.doit.demo3;

/**
 * @ClassName: InnerClass
 * @Author: zll
 * @CreateTime: 2021/6/15 15:08
 * @Desc: java 程序
 * @Version: 1.0
 */
public class InnerClass {
    private int a = 1;

    public Fly getFly(){
        return new Inner();
    }

    //成员内部类实现接口Fly
    private class Inner implements Fly{

        @Override
        public void fly() {
            System.out.println(a);
            System.out.println("成员内部类实现接口Fly");
        }
    }
}
