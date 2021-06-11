package com.doit.demo;

/**
 * @ClassName: PhoneTest
 * @Author: zll
 * @CreateTime: 2021/6/11 10:39
 * @Desc: java 程序
 * @Version: 1.0
 */
public class PhoneTest {
    String color = "father green";
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.setAttr("xiaomi","red",1999);
        p1.show();

        Phone p2 = new Phone();
        p2.show();
    }
}

class MiPhone extends PhoneTest{
    String color = "son yellow";

    public static void main(String[] args){
        new MiPhone().testVar();
    }

    //变量的就近访问原则  局部>成员>父类
    public void testVar(){
        String color ="methods blue";

        System.out.println(color);
        System.out.println(this.color);
        System.out.println(super.color);
    }
}