package com.doit.heritage;
/*
小结：方法的重载与重写
1. 从编译和运行的角度看：
重载，是指允许存在多个同名方法，而这些方法的参数不同。编译器根据方法不
同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了
不同的方法。它们的调用地址在编译期就绑定了。Java的重载是可以包括父类
和子类的，即子类可以重载父类的同名不同参数的方法。
所以：对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，
这称为“早绑定”或“静态绑定”；
而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体
方法，这称为“晚绑定”或“动态绑定”。
引用一句Bruce Eckel的话：“不要犯傻，如果它不是晚绑定，它就不是多态。”
 */

//继承的注意事项：
//java 只支持类的单继承，不支持多继承 ，因为有安全隐患，不知道调的是谁的方法。son不能有多个father
//Java 支持多层继承；A extends Object ; B extends A ; C extends B
//所有类默认继承Object类 ，根类

/**
 * @ClassName: TestHeritage
 * @Author: zll
 * @CreateTime: 2021/6/12 10:34
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TestHeritage {
    public static void main(String[] args) {
        Teacher teach = new Teacher();
        teach.eat();//父类方法覆写
        teach.eat(55);
        teach.hit();

    }
}
