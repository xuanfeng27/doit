package com.doit.demo;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/14 9:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test extends DemoFinal{

    @Override
    public void method() {
        System.out.println("subclass method");
    }

    public static void main(String[] args) {
        /*final*/ int a =3;//常量值无法更改
        a =7;

        final Person p = new Person();//引用类型地址值不变，对象属性值可以修改
        p.age =22;
        p.age =33;

      /*  p = new Person();*/


    }
}
