package com.doit.demo;

/**
 * @ClassName: DemoFinal
 * @Author: zll
 * @CreateTime: 2021/6/14 9:22
 * @Desc: java 程序
 * @Version: 1.0
 */
//final class 无法继承
/*final*/ public class DemoFinal {
     //final int a = 1;//成员变量必须赋值，不能是默认值,或者在每个构造器中都赋值，在创建对象之前赋值
     final int a ;


    public DemoFinal() {
        a =10;
    }

    public/* final*/ void method(){//final 方法无法覆写
        System.out.println("superclass method");
    }
}
