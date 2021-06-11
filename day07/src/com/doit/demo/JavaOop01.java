package com.doit.demo;
/*
面向对象思想总结:
    1.面向过程:当要实现一个功能时,需要亲力亲为,处理每个细节
    2.面向对象:当要实现一个功能时,不关心具体的实现步骤,只关心结果,找一个具有该功能的类,帮我们做事
    3.面向对象的思想
        (1)面向对象是基于面向过程的编程思想.
        (2)面向过程:强调的是每一个功能的步骤
        (3)面向对象:强调的是对象,然后由对象去调用功能
*/

public class JavaOop01 {

    public static void main(String[] args) {
       Person p = new Person();
       p.name = "bean";
       p.age = 22;
       p.adress = "shanghai";
       p.eat();
       p.sleep();
       p.hitBean();
    }
}

/**
 * @ClassName: JavaOop01
 * @Author: zll
 * @CreateTime: 2021/6/11 9:20
 * @Desc: java 程序
 * @Version: 1.0
 */