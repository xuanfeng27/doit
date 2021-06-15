package com.doit.self;

/**
 * @ClassName: Singleton
 * @Author: zll
 * @CreateTime: 2021/6/14 19:44
 * @Desc: java 程序
 * @Version: 1.0
 */
//单例(Singleton)设计模式-饿汉式
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() { }

    public static Singleton getInstance(){
        return  singleton;
    }
}

interface A {
    int x = 0;
    public abstract void me();
}
class B {
    int x = 1;
    public void me(){
        System.out.println("类优先原则");
    };
}
class C extends B implements A {

    public void pX() {
        me();//
       // System.out.println(x);报错 对x的引用不明确
    }
    public static void main(String[] args) {
        new C().pX();
    }
}
/*
接口中的默认方法
 若一个接口中定义了一个默认方法，而另外一个接口中也定义了一个同名同
参数的方法（不管此方法是否是默认方法），在实现类同时实现了这两个接口时，会出现：接口冲突。
 解决办法：实现类必须覆盖接口中同名同参数的方法，来解决冲突。
 若一个接口中定义了一个默认方法，而父类中也定义了一个同名同参数的非
抽象方法，则不会出现冲突问题。因为此时遵守：类优先原则。接口中具有相同名称和参数的默认方法会被忽略。
 */



interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name = name;
    }
    public void play() {
       // ball = new Ball("Football");报错 Cannot assign a value to final variable 'ball'
        System.out.println(ball.getName());
    }
}


interface Filial {// 孝顺的
    default void help() {
        System.out.println("老妈，我来救你了");
    }
}
interface Spoony {// 痴情的
    default void help() {
        System.out.println("媳妇，别怕，我来了");
    }
}

class Man implements Filial, Spoony {
    @Override
    public void help() {
        System.out.println("我该怎么办呢？");
        Filial.super.help();
        Spoony.super.help();
    }

    public static void main(String[] args) {
        new Man().help();
    }
}