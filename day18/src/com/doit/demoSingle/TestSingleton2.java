package com.doit.demoSingle;

/**
 * @ClassName: TestSingleton2
 * @Author: zll
 * @CreateTime: 2021/6/27 19:34
 * @Desc: java 程序
 * @Version: 1.0
 */
//单例模式--懒汉式
//优点  延迟加载 什么时候使用 什么时候创建对象
//缺点  多线程下有问题

public class TestSingleton2 {
    public static void main(String[] args) {
        //Singleton2 s = Singleton2.getInstance();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Singleton2.getInstance());
                }
            }).start();
        }
    }
}
//   DCL单例  double checked locking
class Singleton2 {
    //volatile 防止创建对象时发生指令重排序，得到一个半初始化的对象
    private static volatile Singleton2 s;

    private Singleton2() { }

    public static Singleton2 getInstance(){
        if (s == null) {//提高效率，在这条件判断，就不用走同步了，直接return s
            synchronized (Singleton2.class){
                if (s == null) {//确保只有一个对象被创建
                    s = new Singleton2();
                }
            }
        }

        return s;
    }
}