package com.doit.demo;

/**
 * @ClassName: DemoValitile
 * @Author: zll
 * @CreateTime: 2021/6/27 15:10
 * @Desc: java 程序
 * @Version: 1.0
 */

//并发三大特性之二：可见性
/*
那么如何保证可见性?
1.加锁,比如使用synchronized.
JMM关于synchronized的两条规定：
　1）线程解锁前，必须把共享变量的最新值刷新到主内存中
　2）线程加锁时，将清空工作内存中共享变量的值，从而使用共享变量时需要从主内存中重新获取最新的值

volatile缓存可见性实现原理
底层实现主要是通过汇编lock前缀指令,会锁住这块区域的缓存,并写回主内存.
1.会将当前处理器缓存的行数据立即写回系统内存
2.这个写回内存的操作导致CPU的缓存该内存地址的数值失效(MESI协议)
**注意:**volatile只能保证可见性,但是不能保证原子性,如果要保证原子性,请使用锁
*/
//1.  synchronized    num =  107414208
//2.  volatile关键性  num = 1116822537 效率高
public class DemoVolatile {
    static int num = 0;
    static /*volatile*/ boolean flag = true;//保证可见性

    public static synchronized boolean  getFlag(){
        return flag;
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (getFlag()){//while(flag){num++;}
                    num++;
                }
                System.out.println(num);
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("flag 改为 false");
                flag = false;
                System.out.println(flag);
            }
        }).start();

    }
}
