package com.doit.demo;
/*
面向对象思想总结:
    1.面向过程:当要实现一个功能时,需要亲力亲为,处理每个细节
    2.面向对象:当要实现一个功能时,不关心具体的实现步骤,只关心结果,找一个具有该功能的类,帮我们做事
    3.面向对象的思想
        (1)面向对象是基于面向过程的编程思想.
        (2)面向过程:强调的是每一个功能的步骤
        (3)面向对象:强调的是对象,

注意：如果一个类中，没有定义空参构造方法，Java会自动提供一个空参构造方法，但凡定义一个构造方法（不管有无参数），Java都不会再提供空参构造方法。
JavaBean
如果一个类具备 私有的成员变量  空参构造方法  get/set方法  就是JavaBean
封装：隐藏实现细节，提供公共的访问方式。
*/

public class JavaOop01 {
    private String a="father" ;

    public JavaOop01() {
    }
    //为所有成员变量赋值，即 满参构造
    public JavaOop01(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
       Person p = new Person();

        p.setName("bean");
        p.setAdress("上海");
        p.setAge(22);

        System.out.println(p.getName());
        System.out.println(p.getAdress());
        System.out.println(p.getAge());

       p.eat();
       p.sleep();
       p.hitBean();


    }
}

class SonOop extends JavaOop01{
    private String a ="son";

    public SonOop() {
    }

    public void varTest() {
        String a = "var";
        //变量的就近访问原则 局部>成员>父类
        //this 当前对象的引用，谁调用这个方法，谁就是当前对象
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.getA());
    }

    public static void main(String[] args) {
        new SonOop().varTest();
    }

    @Override
    public String getA() {
        return a;
    }

    @Override
    public void setA(String a) {
        this.a = a;
    }
}

/**
 * @ClassName: JavaOop01
 * @Author: zll
 * @CreateTime: 2021/6/11 9:20
 * @Desc: java 程序
 * @Version: 1.0
 */