package com.doit.duoTai;

/**
 * @ClassName: Test polymorphism
 * @Author: zll
 * @CreateTime: 2021/6/14 9:50
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TestPoly {
    public static void main(String[] args) {

        Cat c = new Cat();
        c.eat();

        Dog d = new Dog();
        d.eat();

        Home h = new Home();
        h.eatAtHome(c);//upcasting 抽象类多态
        h.eatAtHome(d);//upcasting

        h.lookHome(d);//接口类多态 upcasting
        h.lookHome(new Robot());//interface upcasting
        d.lookMe();//use interface default func

        SupTxt txt = new SubTxt();
        txt.txt();//具体类多态

        //多态下，访问成员变量是父类的
        System.out.println(txt.name);//"supname"
        System.out.println(txt.a);//2
        //txt.txt2();错误
        // System.out.println(txt.subname);//错误

    }
}

class SupTxt{
    int a = 2;
    String name = "supname";

    public void txt(){//方法区 父类方法 动态链接 到子类重写方法
        System.out.println("suptxt");
    }
}

class SubTxt extends SupTxt{
    int a = 5;
    String subname = "subname";

    @Override
    public void txt() {//动态链接
        System.out.println("subtxt");
    }

    public void txt2(){
        System.out.println("txt2");
    }
}

